package com.example.sberify.data.db.artists

import androidx.room.Embedded
import androidx.room.Relation
import com.example.sberify.data.db.album.AlbumEntity

/**
 * @author Konstantin Koval
 * @since 09.12.2020
 */
data class ArtistWithAlbums(
    @Embedded val artistEntity: ArtistEntity,
    @Relation(
        parentColumn = "artist_id",
        entityColumn = "parent_artist_id"
    )
    val albumEntities: List<AlbumEntity>
)
