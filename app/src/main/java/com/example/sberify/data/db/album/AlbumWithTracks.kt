package com.example.sberify.data.db.album

import androidx.room.Embedded
import androidx.room.Relation
import com.example.sberify.data.db.track.TrackEntity

/**
 * @author Konstantin Koval
 * @since 09.12.2020
 */
data class AlbumWithTracks(
    @Embedded val albumEntity: AlbumEntity,
    @Relation(
        parentColumn = "album_id",
        entityColumn = "track_id"
    )
    val tracksEntities: List<TrackEntity>
)