package com.example.sberify.di

import com.example.sberify.data.DbConverter
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.ResponseConverter
import com.example.sberify.data.api.GeniusApi
import com.example.sberify.data.api.SpotifyApi
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.repository.DatabaseRepositoryImpl
import com.example.sberify.data.repository.GeniusRepositoryImpl
import com.example.sberify.data.repository.SpotifyRepositoryImpl
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.domain.GeniusRepository
import com.example.sberify.domain.SpotifyRepository
import com.example.sberify.presentation.ui.converter.ViewModelConverter
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
    @Singleton
    fun provideGeniusParser(): GeniusParser {
        return GeniusParser()
    }

    @Provides
    fun provideDbConverter(): DbConverter {
        return DbConverter()
    }

    @Provides
    @Singleton
    fun provideResponseConverter(): ResponseConverter {
        return ResponseConverter()
    }

    @Provides
    @Singleton
    fun provideSpotifyRepository(
        database: AppDatabase,
        spotifyApi: SpotifyApi,
        dbConverter: DbConverter,
        responseConverter: ResponseConverter
    ): SpotifyRepository {
        return SpotifyRepositoryImpl(database, spotifyApi, dbConverter, responseConverter)
    }

    @Provides
    @Singleton
    fun provideGeniusRepository(
        geniusParser: GeniusParser,
        appDatabase: AppDatabase,
        geniusApi: GeniusApi,
        dbConverter: DbConverter,
        responseConverter: ResponseConverter
    ): GeniusRepository {
        return GeniusRepositoryImpl(geniusParser, appDatabase, dbConverter, geniusApi, responseConverter)
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(appDatabase: AppDatabase, dbConverter: DbConverter): DatabaseRepository {
        return DatabaseRepositoryImpl(appDatabase, dbConverter)
    }
}