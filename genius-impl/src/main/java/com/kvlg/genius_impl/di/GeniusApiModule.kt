package com.kvlg.genius_impl.di

import com.kvlg.genius_api.GeniusApi
import com.kvlg.genius_impl.GeniusApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * @author Konstantin Koval
 * @since 28.01.2021
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
interface GeniusApiModule {
    @Binds
    fun provideGeniusApi(impl: GeniusApiImpl): GeniusApi
}