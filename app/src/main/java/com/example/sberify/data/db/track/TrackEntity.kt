package com.example.sberify.data.db.track

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "tracks"
)
data class TrackEntity(
    @PrimaryKey
    @ColumnInfo(name = "track_id")
    val spotifyId: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "parent_album_id")
    val albumId: String,

    @ColumnInfo(name = "lyrics")
    val lyrics: String?,

    @ColumnInfo(name = "artists_id")
    val artistsId: List<String>,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean,

    @ColumnInfo(name = "image_url")
    val imageUrl: String?,

    @ColumnInfo(name = "external_url")
    val externalUrl: String,

    @ColumnInfo(name = "is_explicit")
    val isExplicit: Boolean,

    @ColumnInfo(name = "is_local")
    val isLocal: Boolean,

    @ColumnInfo(name = "markets")
    val markets: List<String>,
)