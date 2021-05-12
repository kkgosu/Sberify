package com.kvlg.analytics.di

import com.kvlg.analytics.AnalyticsInteractor
import com.kvlg.analytics.AnalyticsInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 13.05.2021
 */
@Module
@InstallIn(SingletonComponent::class)
object AnalyticsModule {
    @Provides
    @Singleton
    fun provideAnalyticsInteractor(): AnalyticsInteractor {
        return AnalyticsInteractorImpl()
    }
}