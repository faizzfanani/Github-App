package com.faizzfanani.githubapp.di.module

import com.faizzfanani.githubapp.data.repository.Repository
import com.faizzfanani.githubapp.data.repository.RepositoryImpl
import com.faizzfanani.githubapp.data.source.local.LocalDataSource
import com.faizzfanani.githubapp.data.source.local.LocalDataSourceImpl
import com.faizzfanani.githubapp.data.source.local.dao.UserDao
import com.faizzfanani.githubapp.data.source.remote.RemoteDataSource
import com.faizzfanani.githubapp.data.source.remote.RemoteDataSourceImpl
import com.faizzfanani.githubapp.data.source.remote.service.NetworkService
import com.faizzfanani.githubapp.ui.viewmodel.ViewModelFactory
import com.faizzfanani.githubapp.utils.AppExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    private lateinit var appExecutor : AppExecutor
    @Volatile
    private var viewModelFactory: ViewModelFactory? = null

    @Singleton
    @Provides
    fun provideRemoteDataSource(networkService: NetworkService) : RemoteDataSource {
        return RemoteDataSourceImpl(networkService)
    }
    @Singleton
    @Provides
    fun provideLocalDataSource(userDao: UserDao) : LocalDataSource {
        return LocalDataSourceImpl(userDao)
    }
    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) : Repository {
        appExecutor = AppExecutor()
        return RepositoryImpl(appExecutor, remoteDataSource, localDataSource)
    }
    @Singleton
    @Provides
    fun provideViewModelFactory(repository: Repository) : ViewModelFactory{
        if (viewModelFactory == null) {
            synchronized(ViewModelFactory::class.java) {
                if (viewModelFactory == null) {
                    viewModelFactory = ViewModelFactory(repository)
                }
            }
        }
        return viewModelFactory!!
    }
}