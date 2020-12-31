package com.example.sberify.presentation.ui.converter

import com.example.sberify.models.domain.AlbumDomainModel
import com.example.sberify.models.domain.ArtistDomainModel
import com.example.sberify.models.domain.TrackDomainModel
import com.example.sberify.models.presentation.AlbumModel
import com.example.sberify.models.presentation.ArtistModel
import com.example.sberify.models.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 31.12.2020
 */
class CrowdGiftingViewModelConverter {

    fun convertToTrackViewModel(domain: TrackDomainModel): TrackModel {
        return TrackModel(
            id = domain.id,
            name = domain.name,
            artistNames = domain.artistNames,
            lyrics = domain.lyrics,
            externalUri = domain.externalUri.spotifyUrl,
            explicit = domain.explicit,
            isFavorite = domain.isFavorite,
            previewUri = domain.previewUri
        )
    }

    fun convertToAlbumViewModel(domain: AlbumDomainModel): AlbumModel {
        return AlbumModel(
            id = domain.id,
            name = domain.name,
            artistNames = domain.artistNames,
            tracks = domain.tracks?.map(this::convertToTrackViewModel) ?: emptyList(),
            releaseDate = domain.releaseDate.uiValue,
            totalTracks = domain.totalTracks,
            externalUrl = domain.externalUrl.spotifyUrl,
            imageUrl = domain.images.firstOrNull()?.url,
            copyright = domain.copyright.joinToString(),
            isFavorite = domain.isFavorite
        )
    }

    fun convertToArtistViewModel(domain: ArtistDomainModel): ArtistModel {
        return ArtistModel(
            id = domain.id,
            name = domain.name,
            externalUrl = domain.externalUrlDomainModel.spotifyUrl,
            imageUrl = domain.imageUrl
        )
    }
}