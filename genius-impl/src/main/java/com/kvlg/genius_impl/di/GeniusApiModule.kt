package com.kvlg.genius_impl.di

import com.kvlg.genius_api.GeniusApi
import com.kvlg.genius_impl.GeniusApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Konstantin Koval
 * @since 28.01.2021
 */
@Module
@InstallIn(SingletonComponent::class)
interface GeniusApiModule {
    @Singleton
    @Binds
    fun provideGeniusApi(impl: GeniusApiImpl): GeniusApi
}