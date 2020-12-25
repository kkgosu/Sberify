package com.example.sberify.models.presentation

/**
 * @author Konstantin Koval
 * @since 24.12.2020
 */
data class ArtistModel(
    val id: String,
    val name: String,
    val externalUrl: String,
    val imageUrl: String?
)
