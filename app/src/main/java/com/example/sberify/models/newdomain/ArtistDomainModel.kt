package com.example.sberify.models.newdomain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
@Parcelize
data class ArtistDomainModel(
    val id: String,
    val name: String,
    val externalUrlDomainModel: ExternalUrlDomainModel,
    val imageUrl: String?
) : Parcelable
