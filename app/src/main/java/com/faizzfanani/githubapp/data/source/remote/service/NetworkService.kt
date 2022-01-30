package com.faizzfanani.githubapp.data.source.remote.service

import com.faizzfanani.githubapp.data.source.remote.response.RepositoryResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserDetailResponse
import com.faizzfanani.githubapp.data.source.remote.response.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @GET("users")
    fun getUsers() : Call<List<UserResponse>>

    @GET("users/{login}")
    fun getUserDetails(@Path("login") username : String) : Call<UserDetailResponse>

    @GET("users/{login}/repos")
    fun getUserRepos(@Path("login") username : String) : Call<List<RepositoryResponse>>
}