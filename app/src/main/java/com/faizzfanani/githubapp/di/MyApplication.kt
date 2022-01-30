package com.faizzfanani.githubapp.di

import android.app.Application
import com.faizzfanani.githubapp.di.component.AppComponent
import com.faizzfanani.githubapp.di.component.DaggerAppComponent
import com.faizzfanani.githubapp.di.module.AppModule
import com.faizzfanani.githubapp.di.module.RoomModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication: Application(), HasAndroidInjector {
    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .roomModule(RoomModule(this))
            .build()
    }
    override fun androidInjector(): AndroidInjector<Any> {
        return injector
    }
}