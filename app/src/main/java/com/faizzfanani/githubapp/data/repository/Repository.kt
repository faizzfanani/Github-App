package com.faizzfanani.githubapp.data.repository

import androidx.lifecycle.LiveData
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity
import com.faizzfanani.githubapp.vo.Resource

interface Repository {
    fun getUserList(): LiveData<Resource<List<UserEntity>>>
    fun getUserDetails(username: String): LiveData<Resource<UserDetailEntity>>
    fun getRepos(username: String): LiveData<Resource<List<RepositoryEntity>>>
}