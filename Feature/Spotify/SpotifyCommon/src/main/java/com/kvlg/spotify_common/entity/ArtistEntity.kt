package com.kvlg.spotify_common.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey
    @ColumnInfo(name = "artist_id", index = true)
    val spotifyId: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String?,

    @ColumnInfo(name = "external_url")
    val externalUrl: String,

    @ColumnInfo(name = "popularity")
    val popularity: Int
)