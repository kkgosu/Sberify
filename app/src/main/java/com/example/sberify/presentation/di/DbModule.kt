package com.example.sberify.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.album.AlbumDao
import com.example.sberify.data.db.artists.ArtistDao
import com.example.sberify.data.db.track.TrackDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "database")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideAlbumDao(appDatabase: AppDatabase): AlbumDao {
        return appDatabase.getAlbumDao()
    }

    @Provides
    @Singleton
    fun provideArtistDao(appDatabase: AppDatabase): ArtistDao {
        return appDatabase.getArtistDao()
    }

    @Provides
    @Singleton
    fun provideTrackDao(appDatabase: AppDatabase): TrackDao {
        return appDatabase.getTrackDao()
    }
}