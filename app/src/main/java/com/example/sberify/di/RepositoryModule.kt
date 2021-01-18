package com.example.sberify.di

import com.example.sberify.data.GeniusParser
import com.example.sberify.data.api.GeniusApi
import com.example.sberify.data.api.SpotifyApi
import com.example.sberify.data.repository.DatabaseRepositoryImpl
import com.example.sberify.data.repository.GeniusRepositoryImpl
import com.example.sberify.data.repository.SpotifyRepositoryImpl
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.domain.GeniusRepository
import com.example.sberify.domain.SpotifyRepository
import com.example.sberify.presentation.ui.converter.ViewModelConverter
import com.kvlg.spotify_impl.data.DbConverter
import com.kvlg.spotify_impl.data.ResponseConverter
import com.kvlg.spotify_impl.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    fun provideViewModelConverter(): ViewModelConverter {
        return ViewModelConverter()
    }

    @Provides
    fun provideDbConverter(): com.kvlg.spotify_impl.data.DbConverter {
        return com.kvlg.spotify_impl.data.DbConverter()
    }

    @Provides
    @Singleton
    fun provideSpotifyRepository(
        database: com.kvlg.spotify_impl.data.database.AppDatabase,
        spotifyApi: SpotifyApi,
        dbConverter: com.kvlg.spotify_impl.data.DbConverter,
    ): SpotifyRepository {
        return SpotifyRepositoryImpl(database, spotifyApi, dbConverter, com.kvlg.spotify_impl.data.ResponseConverter())
    }

    @Provides
    @Singleton
    fun provideGeniusRepository(
        appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase,
        geniusApi: GeniusApi,
        dbConverter: com.kvlg.spotify_impl.data.DbConverter,
    ): GeniusRepository {
        return GeniusRepositoryImpl(GeniusParser(), appDatabase, dbConverter, geniusApi)
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase, dbConverter: com.kvlg.spotify_impl.data.DbConverter): DatabaseRepository {
        return DatabaseRepositoryImpl(appDatabase, dbConverter)
    }
}