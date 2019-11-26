package com.example.sberify.data.db.album

import androidx.room.*
import com.example.sberify.data.db.TrackIdConverter
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Track

@Entity(tableName = "albums",
        foreignKeys = [ForeignKey(entity = ArtistEntity::class, parentColumns = ["spotify_id"],
                childColumns = ["artist_id"])])
class AlbumEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private var id: Long,

        @ColumnInfo(name = "spotify_id")
        private var spotifyId: String,

        @ColumnInfo(name = "artist_id")
        private var artistId: String,

        @Embedded
        @ColumnInfo(name = "artist")
        private var artist: Artist,

        @ColumnInfo(name = "name")
        private var name: String,

        @TypeConverters(TrackIdConverter::class)
        @ColumnInfo(name = "track_ids")
        private var trackIds: List<Track>,

        @ColumnInfo(name = "image_url")
        private var imageUrl: String,

        @ColumnInfo(name = "release_date")
        private var releaseDate: String)