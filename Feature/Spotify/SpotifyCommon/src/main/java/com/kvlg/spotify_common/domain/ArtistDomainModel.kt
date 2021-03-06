package com.kvlg.spotify_common.domain

import android.os.Parcelable
import com.kvlg.spotify_common.BaseModel
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
    val imageUrl: String?,
    val popularity: Int
) : BaseModel(id), Parcelable
