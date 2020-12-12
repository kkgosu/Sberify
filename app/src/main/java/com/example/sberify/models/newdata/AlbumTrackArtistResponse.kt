package com.example.sberify.models.newdata

import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.data.db.track.TrackEntity

/**
 * @author Konstantin Koval
 * @since 12.12.2020
 */
data class AlbumTrackArtistResponse(
    val albumInfo: AlbumEntity,
    val artists: List<ArtistEntity>,
    val tracks: List<TrackEntity>
)
