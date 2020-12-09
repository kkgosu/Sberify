package com.example.sberify.data.db.track

import androidx.room.Embedded
import androidx.room.Relation

/**
 * @author Konstantin Koval
 * @since 09.12.2020
 */
data class TracksWithArtist(
    @Embedded val trackEntity: TrackEntity,
    @Relation(
        parentColumn = "track_id",

    )
)
