package com.example.sberify.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sberify.data.db.album.AlbumDao
import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.artists.ArtistDao
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.data.db.suggestions.SuggestionsDao
import com.example.sberify.data.db.suggestions.SuggestionsEntity
import com.example.sberify.data.db.track.TrackDao
import com.example.sberify.data.db.track.TrackEntity

@Database(entities = [ArtistEntity::class, AlbumEntity::class, TrackEntity::class, SuggestionsEntity::class],
        version = 2,
        exportSchema = false)
@TypeConverters(TrackIdConverter::class, ArtistsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getArtistDao(): ArtistDao
    abstract fun getAlbumDao(): AlbumDao
    abstract fun getTrackDao(): TrackDao
    abstract fun getSuggestionsDao(): SuggestionsDao
}