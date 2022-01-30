package com.faizzfanani.githubapp.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UserDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(users: List<UserEntity>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRepos(repos: List<RepositoryEntity>): List<Long>

    @Query("SELECT * FROM UserEntity")
    fun getUserList(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM UserDetailEntity WHERE login = :username")
    fun getUserDetails(username: String): LiveData<UserDetailEntity>

    @Query("SELECT * FROM RepositoryEntity WHERE login = :username")
    fun getRepos(username: String): LiveData<List<RepositoryEntity>>
}