package com.kvlg.spotify_impl.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kvlg.spotify_api.models.entity.AlbumEntity
import com.kvlg.spotify_api.models.entity.ArtistEntity
import com.kvlg.spotify_api.models.entity.TrackEntity
import com.kvlg.spotify_impl.data.database.album.AlbumDao
import com.kvlg.spotify_impl.data.database.artists.ArtistDao
import com.kvlg.spotify_impl.data.database.suggestions.SuggestionsDao
import com.kvlg.spotify_impl.data.database.suggestions.SuggestionsEntity
import com.kvlg.spotify_impl.data.database.track.TrackDao

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