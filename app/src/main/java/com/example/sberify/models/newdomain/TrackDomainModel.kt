package com.example.sberify.models.newdomain

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
data class TrackDomainModel(
    val id: String,
    val name: String,
    val artists: List<ArtistDomainModel>,
    val externalUri: ExternalUrlDomainModel,
    val explicit: Boolean,
    val isLocal: Boolean,
    val previewUri: String,
    val markets: List<String>
)
