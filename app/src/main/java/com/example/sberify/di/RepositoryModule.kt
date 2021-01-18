package com.example.sberify.di

import com.example.sberify.data.api.GeniusApi
import com.example.sberify.data.repository.DatabaseRepositoryImpl
import com.example.sberify.data.repository.GeniusRepositoryImpl
import com.example.sberify.domain.DatabaseRepository
import com.example.sberify.domain.GeniusRepository
import com.example.sberify.presentation.ui.converter.ViewModelConverter
import com.kvlg.genius_impl.data.GeniusParser
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
    fun provideGeniusRepository(
        appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase,
        geniusApi: GeniusApi,
        dbConverter: com.kvlg.spotify_impl.data.DbConverter,
    ): GeniusRepository {
        return GeniusRepositoryImpl(com.kvlg.genius_impl.data.GeniusParser(), appDatabase, dbConverter, geniusApi)
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase, dbConverter: com.kvlg.spotify_impl.data.DbConverter): DatabaseRepository {
        return DatabaseRepositoryImpl(appDatabase, dbConverter)
    }
}