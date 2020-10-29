package com.example.sberify.di

import com.example.sberify.data.repository.DatabaseRepository
import com.example.sberify.data.repository.SpotifyRepository
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.ISpotifyRepository
import com.kvlg.network.spotify.DataConverter
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideSpotifyRepository(
        dataConverter: DataConverter,
        database: AppDatabase,
        spotifyApi: SpotifyApi
    ): ISpotifyRepository {
        return SpotifyRepository(dataConverter, database, spotifyApi)
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(appDatabase: AppDatabase): IDatabaseRepository {
        return DatabaseRepository(appDatabase)
    }
}