package com.kvlg.spotify_api.models.domain

/**
 * @author Konstantin Koval
 * @since 31.12.2020
 */
data class RawTrackModel(
    val id: String,
    val name: String,
    val artistNames: String
)