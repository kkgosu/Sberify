package com.kvlg.spotify_impl.models.data

import com.kvlg.core_db.models.entity.AlbumEntity
import com.kvlg.core_db.models.entity.ArtistEntity
import com.kvlg.core_db.models.entity.TrackEntity

/**
 * @author Konstantin Koval
 * @since 12.12.2020
 */
data class AlbumTrackArtistResponse(
    val albumInfo: AlbumEntity,
    val artists: List<ArtistEntity>,
    val tracks: List<TrackEntity>
)
