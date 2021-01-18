package com.example.sberify.di

import com.example.sberify.data.repository.DatabaseRepositoryImpl
import com.example.sberify.domain.DatabaseRepository
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
    fun provideDatabaseRepository(
        appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase,
        dbConverter: com.kvlg.spotify_impl.data.DbConverter
    ): DatabaseRepository {
        return DatabaseRepositoryImpl(appDatabase, dbConverter)
    }
}