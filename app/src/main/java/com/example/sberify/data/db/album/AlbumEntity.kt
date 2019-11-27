package com.example.sberify.data.db.album

import androidx.room.*
import com.example.sberify.data.db.TrackIdConverter
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Track

@Entity(tableName = "albums"/*,
        foreignKeys = [ForeignKey(entity = ArtistEntity::class,
                parentColumns = ["spotify_id"],
                childColumns = ["artist_id"])]*/)
data class AlbumEntity(
        @PrimaryKey
        @ColumnInfo(name = "spotify_id")
        val spotifyId: String,

        @ColumnInfo(name = "artist_id")
        val artistId: String,
/*
        @Embedded(prefix = "m")
        val artist: Artist,*/

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "track_ids")
        val trackIds: List<Track>,

        @ColumnInfo(name = "image_url")
        val imageUrl: String,

        @ColumnInfo(name = "release_date")
        val releaseDate: String) {

    fun toAlbum(): Album =
            Album(id = spotifyId,
                    artist = Artist(artistId, null, "", null),
                    name = name,
                    tracks = trackIds,
                    imageUrl = imageUrl,
                    releaseDate = releaseDate)

    companion object {
        fun from(album: Album): AlbumEntity =
                AlbumEntity(
                        spotifyId = album.id,
                        artistId = album.artist.id,
                        //artist = album.artist,
                        name = album.name,
                        trackIds = album.tracks!!,
                        imageUrl = album.imageUrl,
                        releaseDate = album.releaseDate)

    }
}