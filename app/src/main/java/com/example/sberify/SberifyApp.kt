package com.example.sberify

import android.app.Application

class SberifyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private lateinit var instance: Application
        fun getContext() = instance.applicationContext
    }
}