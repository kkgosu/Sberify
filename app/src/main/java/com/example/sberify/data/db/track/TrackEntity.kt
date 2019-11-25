package com.example.sberify.data.db.track

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.sberify.data.db.track.album.AlbumEntity

@Entity(tableName = "tracks",
        foreignKeys = [ForeignKey(entity = AlbumEntity::class, parentColumns = ["spotify_id"],
                childColumns = ["album_id"])])
class TrackEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private var id: Long,

        @ColumnInfo(name = "spotify_id")
        private var spotifyId: String,

        @ColumnInfo(name = "album_id")
        private var albumId: String,

        @ColumnInfo(name = "lyrics")
        private var lyrics: String,

        @ColumnInfo(name = "artists")
        private var artists: String,

        @ColumnInfo(name = "image_url")
        private var image_url: String)