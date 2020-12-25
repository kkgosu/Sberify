package com.example.sberify.models.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
@Parcelize
data class ExternalUrlDomainModel(
    val spotifyUrl: String
) : Parcelable