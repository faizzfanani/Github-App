package com.faizzfanani.githubapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity

class FakeLocalDataSource(
    private var userList: List<UserEntity> = mutableListOf(),
    private var userEntity: UserDetailEntity? = null,
    private var repositoryList: List<RepositoryEntity> = mutableListOf()
) : LocalDataSource {
    override fun addUser(userEntity: UserDetailEntity) {
        this.userEntity = userEntity
    }

    override fun addUsers(userList: List<UserEntity>) {
        this.userList = userList.toMutableList()
    }

    override fun addRepos(repos: List<RepositoryEntity>) {
        this.repositoryList = repos.toMutableList()
    }

    override fun getUserList(): LiveData<List<UserEntity>> {
        return liveData {
            if (userList.isNotEmpty()){
                emit(userList)
            }
            else if (userList.isNullOrEmpty()){
                emit(emptyList())
            }
        }
    }

    override fun getUserDetails(username: String): LiveData<UserDetailEntity> {
        return liveData {
            if (userEntity != null){
                val filterData = userEntity.takeIf { it!!.login == username }
                if(filterData != null){
                    userEntity?.let { emit(it) }
                }else{ userEntity?.let { emit(it) }}
            }else{ userEntity?.let { emit(it) }}
        }
    }

    override fun getRepos(username: String): LiveData<List<RepositoryEntity>> {
        return liveData {
            if (repositoryList.isNotEmpty()){
                emit(repositoryList)
            }else if (repositoryList.isNullOrEmpty()){
                emit(emptyList())
            }
        }
    }
}