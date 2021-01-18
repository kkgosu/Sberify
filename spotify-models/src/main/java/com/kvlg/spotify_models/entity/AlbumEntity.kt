package com.kvlg.spotify_models.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "albums"
)
data class AlbumEntity(
    @PrimaryKey
    @ColumnInfo(name = "album_id", index = true)
    val spotifyId: String,

    @ColumnInfo(name = "artist_names", index = true)
    val artistNames: List<String>,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean,

    @ColumnInfo(name = "genres")
    val genres: List<String>,

    @ColumnInfo(name = "total_tracks")
    val totalTracks: Int,

    @ColumnInfo(name = "external_url")
    val externalUrl: String,

    @ColumnInfo(name = "copyrights")
    val copyrights: List<String>,

    @ColumnInfo(name = "markets")
    val markets: List<String>,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "label")
    val label: String
)