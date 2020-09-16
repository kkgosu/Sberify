package com.example.sberify

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.sberify.di.ApiModule
import com.example.sberify.di.DaggerAppComponent
import com.example.sberify.di.DbModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SberifyApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

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