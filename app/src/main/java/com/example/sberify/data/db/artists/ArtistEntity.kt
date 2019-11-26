package com.example.sberify.data.db.artists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
class ArtistEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Long?,

        @ColumnInfo(name = "spotify_id")
        var spotifyId: String,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "image_url")
        var imageUrl: String)