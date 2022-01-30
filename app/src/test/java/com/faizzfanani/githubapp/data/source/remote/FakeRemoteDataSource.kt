package com.faizzfanani.githubapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.faizzfanani.githubapp.data.source.remote.response.ApiResponse
import com.faizzfanani.githubapp.data.source.remote.response.RepositoryResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserDetailResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserResponse

class FakeRemoteDataSource(
    private var userList: List<UserResponse> = mutableListOf(),
    private var userEntity: UserDetailResponse? = null,
    private var repositoryList: List<RepositoryResponse> = mutableListOf()
) : RemoteDataSource {

    override fun getUserList(): LiveData<ApiResponse<List<UserResponse>>> {
        return liveData {
            if (userList.isNullOrEmpty()){
                emit(ApiResponse.Error("Data empty"))
            }else if (userList.isNotEmpty()){
                emit(ApiResponse.Success(userList))
            }
        }
    }

    override fun getUserDetails(username: String): LiveData<ApiResponse<UserDetailResponse>> {
        return liveData {
            if (userEntity != null){
                val filterData = userEntity.takeIf { it!!.login == username }
                if(filterData != null){
                    userEntity?.let { emit(ApiResponse.Success(it)) }
                }else{emit(ApiResponse.Error("Data empty"))}
            }else{emit(ApiResponse.Error("Data empty"))}
        }
    }

    override fun getRepos(username: String): LiveData<ApiResponse<List<RepositoryResponse>>> {
        return liveData {
            if (repositoryList.isNullOrEmpty()){
                emit(ApiResponse.Error("Data empty"))
            }else if (repositoryList.isNotEmpty()){
                emit(ApiResponse.Success(repositoryList))
            }
        }
    }
}