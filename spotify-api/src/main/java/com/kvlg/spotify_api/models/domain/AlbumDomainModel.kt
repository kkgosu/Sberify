package com.kvlg.spotify_api.models.domain

import android.os.Parcelable
import com.kvlg.spotify_api.models.BaseModel
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
@Parcelize
data class AlbumDomainModel(
    val id: String,
    val name: String,
    val artistNames: String,
    val tracks: List<TrackDomainModel>?,
    val genres: List<String>,
    val releaseDate: String,
    val totalTracks: Int,
    val externalUrl: ExternalUrlDomainModel,
    val images: List<ImageDomainModel>,
    val copyright: List<CopyrightDomainModel>,
    val markets: List<String>,
    val albumType: String,
    val label: String,
    val isFavorite: Boolean
) : BaseModel(id), Parcelable
