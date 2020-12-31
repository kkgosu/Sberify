package com.example.sberify.presentation.ui.converter

import com.example.sberify.data.Result
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
class ViewModelConverter {

    fun convertToTrackViewModel(domain: Result<TrackDomainModel>): Result<TrackModel> {
        val data: TrackModel? =
            domain.data?.let {
                TrackModel(
                    id = it.id,
                    name = it.name,
                    artistNames = it.artistNames,
                    lyrics = it.lyrics,
                    externalUri = it.externalUri.spotifyUrl,
                    explicit = it.explicit,
                    isFavorite = it.isFavorite,
                    previewUri = it.previewUri
                )
            }
        return Result(domain.status, data, null)
    }

    fun convertToAlbumViewModel(domain: Result<AlbumDomainModel>): Result<AlbumModel> {
        val data: AlbumModel? =
            domain.data?.let {
                AlbumModel(
                    id = it.id,
                    name = it.name,
                    artistNames = it.artistNames,
                    tracks = it.tracks?.map { t -> convertToTrackViewModel(Result(domain.status, t, null)).data }
                        ?: emptyList(),
                    releaseDate = it.releaseDate.uiValue,
                    totalTracks = it.totalTracks,
                    externalUrl = it.externalUrl.spotifyUrl,
                    imageUrl = it.images.firstOrNull()?.url,
                    copyright = it.copyright.joinToString(),
                    isFavorite = it.isFavorite
                )
            }
        return Result(domain.status, data, null)
    }

    fun convertToArtistViewModel(domain: Result<ArtistDomainModel>): Result<ArtistModel> {
        val data: ArtistModel? =
            domain.data?.let {
                ArtistModel(
                    id = it.id,
                    name = it.name,
                    externalUrl = it.externalUrlDomainModel.spotifyUrl,
                    imageUrl = it.imageUrl
                )
            }
        return Result(domain.status, data, null)
    }
}