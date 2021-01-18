package com.kvlg.spotify_api.di

import com.kvlg.spotify_api.converter.ViewModelConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object SpotifyApiModule {

    @Provides
    fun provideViewModelConverter(): ViewModelConverter {
        return ViewModelConverter()
    }
}