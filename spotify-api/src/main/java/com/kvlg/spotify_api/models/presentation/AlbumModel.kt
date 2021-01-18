package com.kvlg.spotify_api.models.presentation

import android.os.Parcelable
import com.kvlg.spotify_api.models.BaseModel
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 24.12.2020
 */
@Parcelize
data class AlbumModel(
    val id: String,
    val name: String,
    val artistNames: String,
    val tracks: List<TrackModel?>,
    val releaseDate: String,
    val totalTracks: Int,
    val externalUrl: String,
    val imageUrl: String?,
    val copyright: String,
    val isFavorite: Boolean
) : BaseModel(id), Parcelable
