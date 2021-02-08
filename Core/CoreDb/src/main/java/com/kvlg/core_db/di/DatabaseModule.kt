package com.kvlg.core.di

import android.app.Application
import androidx.room.Room
import com.kvlg.core.DatabaseRepository
import com.kvlg.core.DatabaseRepositoryImpl
import com.kvlg.core.database.AppDatabase
import com.kvlg.core.database.album.AlbumDao
import com.kvlg.core.database.artists.ArtistDao
import com.kvlg.core.database.track.TrackDao
import com.kvlg.core_db.database.DbConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object DatabaseModule {

    @Provides
    fun provideDbConverter(): DbConverter {
        return DbConverter()
    }

    @Provides
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

    @Provides
    fun provideDatabaseRepository(
        appDatabase: AppDatabase,
        dbConverter: DbConverter
    ): DatabaseRepository {
        return DatabaseRepositoryImpl(appDatabase, dbConverter)
    }
}