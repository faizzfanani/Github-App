package com.faizzfanani.githubapp.di.module

import com.faizzfanani.githubapp.data.source.local.database.Database
import dagger.Module
import androidx.room.Room

import android.app.Application
import com.faizzfanani.githubapp.data.source.local.dao.UserDao
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule (application: Application) {
    private val database = Room.databaseBuilder(application, Database::class.java, "Github.db").build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): Database {
        return database
    }

    @Singleton
    @Provides
    fun providesUserDao(database: Database): UserDao {
        return database.getUserDao()
    }

}