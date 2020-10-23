package com.kvlg.shared.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kvlg.shared.data.db.album.AlbumDao
import com.kvlg.shared.data.db.album.AlbumEntity
import com.kvlg.shared.data.db.artists.ArtistDao
import com.kvlg.shared.data.db.artists.ArtistEntity
import com.kvlg.shared.data.db.suggestions.SuggestionsDao
import com.kvlg.shared.data.db.suggestions.SuggestionsEntity
import com.kvlg.shared.data.db.track.TrackDao
import com.kvlg.shared.data.db.track.TrackEntity

@Database(
    entities = [ArtistEntity::class,
        AlbumEntity::class,
        TrackEntity::class,
        SuggestionsEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(TrackIdConverter::class, ArtistsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getArtistDao(): ArtistDao
    abstract fun getAlbumDao(): AlbumDao
    abstract fun getTrackDao(): TrackDao
    abstract fun getSuggestionsDao(): SuggestionsDao
}