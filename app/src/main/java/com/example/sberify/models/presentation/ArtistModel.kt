package com.example.sberify.models.presentation

import android.os.Parcelable
import com.example.sberify.models.domain.BaseModel
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 24.12.2020
 */
@Parcelize
data class ArtistModel(
    val id: String,
    val name: String,
    val externalUrl: String,
    val imageUrl: String?
) : BaseModel(id), Parcelable
