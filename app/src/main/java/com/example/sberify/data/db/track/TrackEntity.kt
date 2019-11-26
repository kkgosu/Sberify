package com.example.sberify.data.db.track

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.sberify.data.db.album.AlbumEntity

@Entity(tableName = "tracks"/*,
        foreignKeys = [ForeignKey(entity = AlbumEntity::class, parentColumns = ["spotify_id"],
                childColumns = ["album_id"])]*/)
class TrackEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Long?,

        @ColumnInfo(name = "spotify_id")
        var spotifyId: String,

        @ColumnInfo(name = "album_id")
        var albumId: String,

        @ColumnInfo(name = "lyrics")
        var lyrics: String,

        @ColumnInfo(name = "artists")
        var artists: String,

        @ColumnInfo(name = "image_url")
        var image_url: String)