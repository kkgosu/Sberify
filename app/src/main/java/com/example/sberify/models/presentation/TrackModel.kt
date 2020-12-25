package com.example.sberify.models.presentation

/**
 * @author Konstantin Koval
 * @since 24.12.2020
 */
data class TrackModel(
    val id: String,
    val name: String,
    val artistNames: String,
    var lyrics: String? = null,
    val externalUri: String,
    val explicit: Boolean,
    var isFavorite: Boolean,
    val previewUri: String,
)
