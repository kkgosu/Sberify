package com.kvlg.spotify_common.presentation

import android.os.Parcelable
import com.kvlg.spotify_common.BaseModel
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
    val explicit: Boolean,
    var isFavorite: Boolean,
    val previewUri: String,
    val uri: String
) : BaseModel(id), Parcelable
