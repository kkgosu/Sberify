package com.example.sberify.data.db.album

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Track

@Entity(tableName = "albums"/*,
        foreignKeys = [ForeignKey(entity = ArtistEntity::class,
                parentColumns = ["spotify_id"],
                childColumns = ["artist_id"])]*/)
data class AlbumEntity(
    @PrimaryKey
    @ColumnInfo(name = "spotify_id", index = true)
    val spotifyId: String,

    @ColumnInfo(name = "artist_id", index = true)
    val artistId: String,

    @Embedded(prefix = "m")
    val artist: ArtistEntity,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "track_ids")
    val trackIds: List<Track>?,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean) {

    fun toAlbum(): Album =
        Album(id = spotifyId,
            artist = artist.toArtist(),
            name = name,
            tracks = trackIds,
            imageUrl = imageUrl,
            releaseDate = releaseDate,
            isFavorite = isFavorite)

    companion object {
        fun from(album: Album): AlbumEntity =
            AlbumEntity(
                spotifyId = album.id,
                artistId = album.artist.id,
                artist = ArtistEntity.from(album.artist),
                name = album.name,
                trackIds = album.tracks,
                imageUrl = album.imageUrl,
                releaseDate = album.releaseDate,
                isFavorite = album.isFavorite)

    }
}