package com.kvlg.spotify_api.di

import android.app.Application
import androidx.room.Room
import com.kvlg.spotify_api.data.database.AppDatabase
import com.kvlg.spotify_api.data.database.album.AlbumDao
import com.kvlg.spotify_api.data.database.artists.ArtistDao
import com.kvlg.spotify_api.data.database.track.TrackDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAlbumDao(appDatabase: AppDatabase): AlbumDao {
        return appDatabase.getAlbumDao()
    }

    @Provides
    fun provideArtistDao(appDatabase: AppDatabase): ArtistDao {
        return appDatabase.getArtistDao()
    }

    @Provides
    fun provideTrackDao(appDatabase: AppDatabase): TrackDao {
        return appDatabase.getTrackDao()
    }
}