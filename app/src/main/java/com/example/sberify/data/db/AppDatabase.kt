package com.example.sberify.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sberify.data.db.album.AlbumDao
import com.example.sberify.data.db.artists.ArtistDao
import com.example.sberify.data.db.suggestions.SuggestionsDao
import com.example.sberify.data.db.suggestions.SuggestionsEntity
import com.example.sberify.data.db.track.TrackDao
import com.kvlg.spotify.models.entity.AlbumEntity
import com.kvlg.spotify.models.entity.ArtistEntity
import com.kvlg.spotify.models.entity.TrackEntity

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