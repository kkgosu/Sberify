package com.kvlg.spotify_impl.di

import com.kvlg.spotify_api.api.SpotifyApi
import com.kvlg.spotify_impl.SpotifyApiImpl
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
interface SpotifyApiModule {

    @Singleton
    @Binds
    fun provideSpotifyApi(impl: SpotifyApiImpl): SpotifyApi
}