package com.kvlg.core.database.track

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.kvlg.spotify_models.entity.ArtistEntity
import com.kvlg.spotify_models.entity.TrackEntity

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
