package com.example.sberify.data.db.artists

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.sberify.data.db.track.TrackArtistCrossRef
import com.example.sberify.data.db.track.TrackEntity

/**
 * @author Konstantin Koval
 * @since 10.12.2020
 */
data class ArtistWithSongs(
    @Embedded val artist: ArtistEntity,
    @Relation(
        parentColumn = "artist_id",
        entityColumn = "track_id",
        associateBy = Junction(TrackArtistCrossRef::class)
    )
    val tracks: List<TrackEntity>
)
