package com.kvlg.spotify_common.presentation

import android.os.Parcelable
import com.kvlg.spotify_common.BaseModel
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
