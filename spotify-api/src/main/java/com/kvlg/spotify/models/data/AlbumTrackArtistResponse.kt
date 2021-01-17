package com.kvlg.spotify.models.data

import com.kvlg.spotify.models.entity.AlbumEntity
import com.kvlg.spotify.models.entity.ArtistEntity
import com.kvlg.spotify.models.entity.TrackEntity

/**
 * @author Konstantin Koval
 * @since 12.12.2020
 */
data class AlbumTrackArtistResponse(
    val albumInfo: AlbumEntity,
    val artists: List<ArtistEntity>,
    val tracks: List<TrackEntity>
)
