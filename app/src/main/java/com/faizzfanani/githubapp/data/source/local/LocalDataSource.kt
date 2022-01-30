package com.faizzfanani.githubapp.data.source.local

import androidx.lifecycle.LiveData
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity

interface LocalDataSource {
    fun addUser(userEntity: UserDetailEntity)
    fun addUsers(userList: List<UserEntity>)
    fun addRepos(repos: List<RepositoryEntity>)
    fun getUserList(): LiveData<List<UserEntity>>
    fun getUserDetails(username:String): LiveData<UserDetailEntity>
    fun getRepos(username:String): LiveData<List<RepositoryEntity>>
}