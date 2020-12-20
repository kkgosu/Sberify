package com.example.sberify.models.newdomain

import android.os.Parcelable
import com.example.sberify.models.domain.BaseModel
import kotlinx.android.parcel.Parcelize

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
@Parcelize
data class AlbumDomainModel(
    val id: String,
    val name: String,
    val tracks: List<TrackDomainModel>?,
    val genres: List<String>,
    val releaseDate: PrecisionDate,
    val totalTracks: Int,
    val externalUrl: ExternalUrlDomainModel,
    val images: List<ImageDomainModel>,
    val copyright: List<CopyrightDomainModel>,
    val markets: List<String>,
    val albumType: String,
    val label: String
) : BaseModel(id), Parcelable
