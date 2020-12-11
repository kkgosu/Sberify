package com.example.sberify.data.db.album

import androidx.room.Embedded
import androidx.room.Relation
import com.example.sberify.data.db.artists.ArtistEntity

/**
 * @author Konstantin Koval
 * @since 11.12.2020
 */
data class AlbumWithArtists(
    @Embedded val albumEntity: AlbumEntity,
    @Relation(
        parentColumn = "album_id",
        entityColumn = "artist_id"
    )
    val artistEntities: List<ArtistEntity>
)
