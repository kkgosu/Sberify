package com.kvlg.core_db.di

import android.app.Application
import androidx.room.Room
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_db.DatabaseRepositoryImpl
import com.kvlg.core_db.database.AppDatabase
import com.kvlg.core_db.database.DbConverter
import com.kvlg.core_db.database.album.AlbumDao
import com.kvlg.core_db.database.artists.ArtistDao
import com.kvlg.core_db.database.track.TrackDao
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
internal object DatabaseModule {

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