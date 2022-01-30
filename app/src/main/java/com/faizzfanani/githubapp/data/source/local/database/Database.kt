package com.faizzfanani.githubapp.data.source.local.database

import androidx.room.RoomDatabase
import com.faizzfanani.githubapp.data.source.local.dao.UserDao
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity

@androidx.room.Database(entities = [UserEntity::class, UserDetailEntity::class, RepositoryEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun getUserDao() : UserDao
}