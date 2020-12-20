package com.example.sberify.models.newdomain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
@Parcelize
data class ImageDomainModel(
    val url: String
) : Parcelable
