package com.example.sberify.models.newdomain

/**
 * @author Konstantin Koval
 * @since 06.12.2020
 */
data class AlbumDomainModel(
    val id: String,
    val name: String,
    val tracks: List<TrackDomainModel>?,
    val genres: List<String>,
    val releaseDate: PrecisionDate,
    val totalTracks: Int,
    val externalUrl: ExternalUrlDomainModel,
    val images: List<ImageDomainModel>,
    val copyright: List<CopyrightDomainModel>,
    val markets: List<String>,
    val albumType: String,
    val label: String
)
