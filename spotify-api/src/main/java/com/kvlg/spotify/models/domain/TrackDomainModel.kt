package com.kvlg.spotify.models.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
@Parcelize
data class TrackDomainModel(
    val id: String,
    val name: String,
    val artistNames: String,
    var lyrics: String? = null,
    val externalUri: ExternalUrlDomainModel,
    val explicit: Boolean,
    val isLocal: Boolean,
    var isFavorite: Boolean,
    val previewUri: String,
    val markets: List<String>
) : BaseModel(id), Parcelable
