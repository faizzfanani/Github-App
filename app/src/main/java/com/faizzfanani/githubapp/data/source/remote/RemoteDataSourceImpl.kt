package com.faizzfanani.githubapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.faizzfanani.githubapp.data.source.remote.response.ApiResponse
import com.faizzfanani.githubapp.data.source.remote.response.RepositoryResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserDetailResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserResponse
import com.faizzfanani.githubapp.data.source.remote.service.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val networkService: NetworkService) : RemoteDataSource {

    override fun getUserList(): LiveData<ApiResponse<List<UserResponse>>> {
        val result = MutableLiveData<ApiResponse<List<UserResponse>>>()
        networkService.getUsers().enqueue(object : Callback<List<UserResponse>>{
            override fun onResponse(
                    call: Call<List<UserResponse>>,
                    response: Response<List<UserResponse>>
            ) {
                if (response.body().isNullOrEmpty()){
                    result.value = ApiResponse.Empty
                }else {
                    result.value = ApiResponse.Success(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                result.value = ApiResponse.Error("Failed to retrieve data")
            }

        })
        return result
    }
    override fun getUserDetails(username: String): LiveData<ApiResponse<UserDetailResponse>>{
        val result = MutableLiveData<ApiResponse<UserDetailResponse>>()
        networkService.getUserDetails(username).enqueue(object : Callback<UserDetailResponse>{
            override fun onResponse(
                    call: Call<UserDetailResponse>,
                    response: Response<UserDetailResponse>
            ) {
                if (response.body()?.id == null){
                    result.value = ApiResponse.Empty
                }else {
                    result.value = ApiResponse.Success(response.body()!!)
                }
            }

            override fun onFailure(call: Call<UserDetailResponse>, t: Throwable) {
                result.value = ApiResponse.Error("Failed to retrieve data")
            }

        })
        return result
    }
    override fun getRepos(username: String): LiveData<ApiResponse<List<RepositoryResponse>>> {
        val result = MutableLiveData<ApiResponse<List<RepositoryResponse>>>()
        networkService.getUserRepos(username).enqueue(object : Callback<List<RepositoryResponse>>{
            override fun onResponse(
                call: Call<List<RepositoryResponse>>,
                response: Response<List<RepositoryResponse>>
            ) {
                if (response.body().isNullOrEmpty()){
                    result.value = ApiResponse.Empty
                }else {
                    result.value = ApiResponse.Success(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<RepositoryResponse>>, t: Throwable) {
                result.value = ApiResponse.Error("Failed to retrieve data")
            }

        })
        return result
    }
}