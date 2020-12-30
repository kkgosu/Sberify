package com.example.sberify

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SberifyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        Timber.plant(Timber.DebugTree())
    }

}