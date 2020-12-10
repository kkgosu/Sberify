package com.example.sberify.data.db.track

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.sberify.data.db.artists.ArtistEntity

/**
 * @author Konstantin Koval
 * @since 10.12.2020
 */
data class TrackWithArtists(
    @Embedded val track: TrackEntity,
    @Relation(
        parentColumn = "track_id",
        entityColumn = "artist_id",
        associateBy = Junction(TrackArtistCrossRef::class)
    )
    val artists: List<ArtistEntity>
)
