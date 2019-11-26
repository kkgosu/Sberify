package com.example.sberify.data.db.artists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
class ArtistEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private var id: Long,

        @ColumnInfo(name = "spotify_id")
        private var spotifyId: String,

        @ColumnInfo(name = "name")
        private var name: String,

        @ColumnInfo(name = "image_url")
        private var imageUrl: String)