package com.kvlg.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kvlg.core.database.album.AlbumDao
import com.kvlg.core.database.artists.ArtistDao
import com.kvlg.core.database.suggestions.SuggestionsDao
import com.kvlg.core.database.suggestions.SuggestionsEntity
import com.kvlg.core.database.track.TrackDao
import com.kvlg.spotify_models.entity.AlbumEntity
import com.kvlg.spotify_models.entity.ArtistEntity
import com.kvlg.spotify_models.entity.TrackEntity

@Database(
    entities = [
        ArtistEntity::class,
        AlbumEntity::class,
        TrackEntity::class,
        SuggestionsEntity::class
    ],
    version = 8,
    exportSchema = false
)
@TypeConverters(ListToStringConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getArtistDao(): ArtistDao
    abstract fun getAlbumDao(): AlbumDao
    abstract fun getTrackDao(): TrackDao
    abstract fun getSuggestionsDao(): SuggestionsDao
}