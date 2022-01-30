package com.faizzfanani.githubapp.di.component

import com.faizzfanani.githubapp.di.module.AppModule
import com.faizzfanani.githubapp.di.module.DataSourceModule
import com.faizzfanani.githubapp.di.module.NetworkModule
import com.faizzfanani.githubapp.di.module.RoomModule
import com.faizzfanani.githubapp.ui.detail.DetailActivity
import com.faizzfanani.githubapp.ui.list.ListActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    RoomModule::class,
    DataSourceModule::class
])
interface AppComponent {
    fun inject(activity: ListActivity)
    fun inject(activity: DetailActivity)
}