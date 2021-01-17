package com.example.sberify.di

import android.app.Application
import androidx.room.Room
import com.kvlg.spotify_impl.data.database.AppDatabase
import com.kvlg.spotify_impl.data.database.album.AlbumDao
import com.kvlg.spotify_impl.data.database.artists.ArtistDao
import com.kvlg.spotify_impl.data.database.track.TrackDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DbModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): com.kvlg.spotify_impl.data.database.AppDatabase {
        return Room.databaseBuilder(application, com.kvlg.spotify_impl.data.database.AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAlbumDao(appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase): com.kvlg.spotify_impl.data.database.album.AlbumDao {
        return appDatabase.getAlbumDao()
    }

    @Provides
    fun provideArtistDao(appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase): com.kvlg.spotify_impl.data.database.artists.ArtistDao {
        return appDatabase.getArtistDao()
    }

    @Provides
    fun provideTrackDao(appDatabase: com.kvlg.spotify_impl.data.database.AppDatabase): com.kvlg.spotify_impl.data.database.track.TrackDao {
        return appDatabase.getTrackDao()
    }
}