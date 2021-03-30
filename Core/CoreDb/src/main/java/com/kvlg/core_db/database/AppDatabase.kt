package com.kvlg.core_db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kvlg.core_db.database.album.AlbumDao
import com.kvlg.core_db.database.artists.ArtistDao
import com.kvlg.core_db.database.suggestions.SuggestionsDao
import com.kvlg.core_db.database.suggestions.SuggestionsEntity
import com.kvlg.core_db.database.track.TrackDao
import com.kvlg.spotify_common.entity.AlbumEntity
import com.kvlg.spotify_common.entity.ArtistEntity
import com.kvlg.spotify_common.entity.TrackEntity

@Database(
    entities = [
        ArtistEntity::class,
        AlbumEntity::class,
        TrackEntity::class,
        SuggestionsEntity::class
    ],
    version = 9,
    exportSchema = false
)
@TypeConverters(ListToStringConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getArtistDao(): ArtistDao
    abstract fun getAlbumDao(): AlbumDao
    abstract fun getTrackDao(): TrackDao
    abstract fun getSuggestionsDao(): SuggestionsDao
}