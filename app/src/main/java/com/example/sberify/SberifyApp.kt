package com.example.sberify

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SberifyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        Timber.plant(Timber.DebugTree())

        val config = YandexMetricaConfig.newConfigBuilder(BuildConfig.APP_METRICA_API_KEY)
            .withLogs()
            .withStatisticsSending(true)
            .build()
        YandexMetrica.activate(this, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}