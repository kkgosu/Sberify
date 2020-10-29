package com.kvlg.shared.data.db.artists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Image

@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey
    @ColumnInfo(name = "spotify_id")
    val spotifyId: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String?
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
                imageUrl = artist.image?.url
            )
    }
}