package com.kvlg.spotify_impl.data.database.track

import androidx.room.Entity

/**
 * @author Konstantin Koval
 * @since 09.12.2020
 */
@Entity(primaryKeys = ["artist_id", "track_id"])
data class TrackArtistCrossRef(
    val artist_id: Long,
    val track_id: Long
)
