package com.faizzfanani.githubapp.data.source.remote

import androidx.lifecycle.LiveData
import com.faizzfanani.githubapp.data.source.remote.response.ApiResponse
import com.faizzfanani.githubapp.data.source.remote.response.RepositoryResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserDetailResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserResponse

interface RemoteDataSource {
    fun getUserList(): LiveData<ApiResponse<List<UserResponse>>>
    fun getUserDetails(username: String): LiveData<ApiResponse<UserDetailResponse>>
    fun getRepos(username: String): LiveData<ApiResponse<List<RepositoryResponse>>>
}