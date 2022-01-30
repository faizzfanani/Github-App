package com.faizzfanani.githubapp.data.source.local

import androidx.lifecycle.LiveData
import com.faizzfanani.githubapp.data.source.local.dao.UserDao
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity
import javax.inject.Inject

open class LocalDataSourceImpl @Inject constructor(private val userDao: UserDao) : LocalDataSource {

    override fun addUser(userEntity: UserDetailEntity){
        userDao.addUser(userEntity)
    }
    override fun addUsers(userList: List<UserEntity>){
        userDao.addUsers(userList)
    }
    override fun addRepos(repos: List<RepositoryEntity>){
        userDao.addRepos(repos)
    }
    override fun getUserList(): LiveData<List<UserEntity>> {
        return userDao.getUserList()
    }
    override fun getUserDetails(username: String):LiveData<UserDetailEntity>{
        return userDao.getUserDetails(username)
    }
    override fun getRepos(username: String):LiveData<List<RepositoryEntity>>{
        return userDao.getRepos(username)
    }
}