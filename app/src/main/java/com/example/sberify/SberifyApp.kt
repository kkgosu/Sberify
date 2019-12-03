package com.example.sberify

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.sberify.presentation.di.ApiModule
import com.example.sberify.presentation.di.DaggerAppComponent
import com.example.sberify.presentation.di.DbModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SberifyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector


    override fun onCreate() {
        super.onCreate()
        instance = this
        
        DaggerAppComponent.builder()
                .application(this)
                .apiModule(ApiModule())
                .dbModule(DbModule())
                .build()
                .inject(this)
    }

    companion object {
        private lateinit var instance: Application
        fun getContext(): Context = instance.applicationContext
    }
}