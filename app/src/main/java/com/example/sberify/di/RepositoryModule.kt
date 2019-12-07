package com.example.sberify.di

import com.example.sberify.data.DataConverter
import com.example.sberify.data.GeniusParser
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.repository.DatabaseRepository
import com.example.sberify.data.repository.GeniusRepository
import com.example.sberify.data.repository.SpotifyRepository
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.IGeniusRepository
import com.example.sberify.domain.ISpotifyRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
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
    @Singleton
    fun provideSpotifyRepository(dataConverter: DataConverter,
            database: AppDatabase,
            spotifyApi: ISpotifyApi): ISpotifyRepository {
        return SpotifyRepository(dataConverter, database, spotifyApi)
    }

    @Provides
    @Singleton
    fun provideGeniusRepository(geniusParser: GeniusParser,
            appDatabase: AppDatabase): IGeniusRepository {
        return GeniusRepository(geniusParser, appDatabase)
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(appDatabase: AppDatabase): IDatabaseRepository {
        return DatabaseRepository(appDatabase)
    }
}