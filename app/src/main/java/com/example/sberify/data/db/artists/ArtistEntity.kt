package com.example.sberify.data.db.artists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Image

@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey
    @ColumnInfo(name = "artist_id")
    val spotifyId: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String?,

    @ColumnInfo(name = "external_url")
    val externalUrl: String
) {

    fun toArtist(): Artist =
        Artist(
            id = spotifyId,
            name = name,
            image = Image(imageUrl, 0, 0),
            genres = null
        )

    companion object {
        fun from(artist: Artist): ArtistEntity =
            ArtistEntity(
                spotifyId = artist.id,
                name = artist.name,
                imageUrl = artist.image?.url,
                externalUrl = ""
            )
    }
}