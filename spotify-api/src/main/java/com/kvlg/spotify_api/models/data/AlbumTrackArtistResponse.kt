package com.kvlg.spotify_api.models.data

import com.kvlg.spotify_api.models.entity.AlbumEntity
import com.kvlg.spotify_api.models.entity.ArtistEntity
import com.kvlg.spotify_api.models.entity.TrackEntity

/**
 * @author Konstantin Koval
 * @since 12.12.2020
 */
data class AlbumTrackArtistResponse(
    val albumInfo: AlbumEntity,
    val artists: List<ArtistEntity>,
    val tracks: List<TrackEntity>
)
