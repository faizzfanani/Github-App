package com.faizzfanani.githubapp.data.repository

import androidx.lifecycle.LiveData
import com.faizzfanani.githubapp.data.NetworkBoundResource
import com.faizzfanani.githubapp.data.source.local.LocalDataSource
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryOwner
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity
import com.faizzfanani.githubapp.data.source.remote.RemoteDataSource
import com.faizzfanani.githubapp.data.source.remote.response.ApiResponse
import com.faizzfanani.githubapp.data.source.remote.response.RepositoryResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserDetailResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserResponse
import com.faizzfanani.githubapp.utils.AppExecutor
import com.faizzfanani.githubapp.vo.Resource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val appExecutor: AppExecutor,
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override fun getUserList(): LiveData<Resource<List<UserEntity>>> {
        return object : NetworkBoundResource<List<UserEntity>, List<UserResponse>>(appExecutor) {
            @Suppress("UNCHECKED_CAST")
            override fun loadFromDB(): LiveData<List<UserEntity>> {
                return localDataSource.getUserList()
            }

            override fun shouldFetch(data: List<UserEntity>?): Boolean {
                return true
            }

            override fun createCall(): LiveData<ApiResponse<List<UserResponse>>> {
                return remoteDataSource.getUserList()
            }

            override fun saveCallResult(data: List<UserResponse>) {
                val userList = data.map {
                    UserEntity(it.id, it.login, it.nodeID, it.avatarURL, it.url, it.followerURL, it.followingURL, it.subscriptionURL, it.organizationURL, it.reposURL, it.eventsURL, it.type)
                }
                localDataSource.addUsers(userList)
            }

        }.asLiveData()
    }

    override fun getUserDetails(username: String): LiveData<Resource<UserDetailEntity>> {
        return object : NetworkBoundResource<UserDetailEntity, UserDetailResponse>(appExecutor) {
            override fun loadFromDB(): LiveData<UserDetailEntity> {
                return localDataSource.getUserDetails(username)
            }

            override fun shouldFetch(data: UserDetailEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<UserDetailResponse>> {
                return remoteDataSource.getUserDetails(username)
            }

            override fun saveCallResult(data: UserDetailResponse) {
                val userEntity = UserDetailEntity(data.id, data.login, data.name, data.location, data.bio, data.nodeID, data.avatarURL, data.url, data.publicRepos, data.followers, data.following, data.type)
                localDataSource.addUser(userEntity)
            }

        }.asLiveData()
    }

    override fun getRepos(username: String): LiveData<Resource<List<RepositoryEntity>>> {
        return object : NetworkBoundResource<List<RepositoryEntity>, List<RepositoryResponse>>(appExecutor) {
            override fun loadFromDB(): LiveData<List<RepositoryEntity>> {
                return localDataSource.getRepos(username)
            }

            override fun shouldFetch(data: List<RepositoryEntity>?): Boolean {
                return true
            }

            override fun createCall(): LiveData<ApiResponse<List<RepositoryResponse>>> {
                return remoteDataSource.getRepos(username)
            }

            override fun saveCallResult(data: List<RepositoryResponse>) {
                val repos = data.map {
                    RepositoryEntity(it.id, RepositoryOwner(it.owner.login), it.name, it.fullName, it.nodeID, it.description, it.updatedAt, it.starCount, it.language)
                }
                localDataSource.addRepos(repos)
            }

        }.asLiveData()
    }
}