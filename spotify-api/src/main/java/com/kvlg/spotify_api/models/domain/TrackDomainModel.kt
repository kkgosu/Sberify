package com.kvlg.spotify_api.models.domain

import android.os.Parcelable
import com.kvlg.spotify_api.models.BaseModel
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
