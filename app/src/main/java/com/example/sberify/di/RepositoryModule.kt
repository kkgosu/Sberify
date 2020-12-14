package com.example.sberify.di

import com.example.sberify.data.DataConverter
import com.example.sberify.data.DbConverter
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.ResponseConverter
import com.example.sberify.data.api.IGeniusApi
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.repository.DatabaseRepositoryImpl
import com.example.sberify.data.repository.GeniusRepository
import com.example.sberify.data.repository.SpotifyRepository
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDataConverter(): DataConverter {
        return DataConverter()
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
        spotifyApi: ISpotifyApi,
        dbConverter: DbConverter,
        responseConverter: ResponseConverter
    ): ISpotifyRepository {
        return SpotifyRepository(database, spotifyApi, dbConverter, responseConverter)
    }


    @Provides
    @Singleton
    fun provideGeniusRepository(
        geniusParser: GeniusParser,
        appDatabase: AppDatabase,
        geniusApi: IGeniusApi
    ): IGeniusRepository {
        return GeniusRepository(geniusParser, appDatabase, geniusApi)
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(appDatabase: AppDatabase, dbConverter: DbConverter): DatabaseRepository {
        return DatabaseRepositoryImpl(appDatabase, dbConverter)
    }
}