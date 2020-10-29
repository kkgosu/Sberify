package com.kvlg.shared.data.db.track

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kvlg.model.presentation.Artist

@Entity(tableName = "tracks")
data class TrackEntity(
        @PrimaryKey
        @ColumnInfo(name = "spotify_id")
        val spotifyId: String,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "album_id")
        val albumId: String,

        @ColumnInfo(name = "lyrics")
        val lyrics: String?,

        @ColumnInfo(name = "artists")
        val artists: List<Artist>,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean,

        @ColumnInfo(name = "image_url")
        val image_url: String?
)