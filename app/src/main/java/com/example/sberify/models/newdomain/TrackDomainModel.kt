package com.example.sberify.models.newdomain

import android.os.Parcelable
import com.example.sberify.models.domain.BaseModel
import kotlinx.parcelize.Parcelize

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
@Parcelize
data class TrackDomainModel(
    val id: String,
    val name: String,
    val artists: List<ArtistDomainModel>,
    var lyrics: String? = null,
    val externalUri: ExternalUrlDomainModel,
    val explicit: Boolean,
    val isLocal: Boolean,
    var isFavorite: Boolean,
    val previewUri: String,
    val markets: List<String>
) : BaseModel(id), Parcelable
