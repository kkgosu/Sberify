package com.kvlg.spotify_models.domain

/**
 * @author Konstantin Koval
 * @since 31.12.2020
 */
data class RawTrackDomainModel(
    val id: String,
    val name: String,
    val artistNames: String
)