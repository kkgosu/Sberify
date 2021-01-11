package com.example.sberify.models.presentation

import android.os.Parcelable
import com.example.sberify.models.domain.BaseModel
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 24.12.2020
 */
@Parcelize
data class TrackModel(
    val id: String,
    val name: String,
    val artistNames: String,
    var lyrics: String? = null,
    val externalUri: String,
    val explicit: Boolean,
    var isFavorite: Boolean,
    val previewUri: String,
) : BaseModel(id), Parcelable
