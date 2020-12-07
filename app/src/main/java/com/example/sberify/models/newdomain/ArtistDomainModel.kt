package com.example.sberify.models.newdomain

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
data class ArtistDomainModel(
    val id: String,
    val name: String,
    val externalUrlDomainModel: ExternalUrlDomainModel,
    val imageUrl: String?
)
