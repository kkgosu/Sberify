package com.kvlg.spotify_api.converter

import com.kvlg.core.Result
import com.kvlg.spotify_models.domain.AlbumDomainModel
import com.kvlg.spotify_models.domain.ArtistDomainModel
import com.kvlg.spotify_models.domain.TrackDomainModel
import com.kvlg.spotify_models.presentation.AlbumModel
import com.kvlg.spotify_models.presentation.ArtistModel
import com.kvlg.spotify_models.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 31.12.2020
 */
class ViewModelConverter {

    fun convertToArtistViewModelList(domain: Result<List<ArtistDomainModel>>): Result<List<ArtistModel>> {
        val data: List<ArtistModel>? = domain.data?.map(this::makeArtistModel)
        return Result(domain.status, data, domain.message)
    }

    fun convertToAlbumViewModelList(domain: Result<List<AlbumDomainModel>>): Result<List<AlbumModel>> {
        val data: List<AlbumModel>? = domain.data?.map { makeAlbumModel(it, domain.status, domain.message) }
        return Result(domain.status, data, domain.message)
    }

    fun convertToTrackViewModelList(domain: Result<List<TrackDomainModel>>): Result<List<TrackModel>> {
        val data: List<TrackModel>? = domain.data?.map(this::makeTrackModel)
        return Result(domain.status, data, domain.message)
    }

    fun convertToTrackViewModel(domain: Result<TrackDomainModel?>): Result<TrackModel> {
        val data: TrackModel? = domain.data?.let(this::makeTrackModel)
        return Result(domain.status, data, domain.message)
    }

    fun convertToAlbumViewModel(domain: Result<AlbumDomainModel>): Result<AlbumModel> {
        val data: AlbumModel? =
            domain.data?.let {
                makeAlbumModel(it, domain.status, domain.message)
            }
        return Result(domain.status, data, domain.message)
    }

    fun convertToArtistViewModel(domain: Result<ArtistDomainModel>): Result<ArtistModel> {
        val data: ArtistModel? = domain.data?.let(this::makeArtistModel)
        return Result(domain.status, data, domain.message)
    }

    fun makeTrackModel(it: TrackDomainModel): TrackModel {
        return TrackModel(
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

    fun makeAlbumModel(
        it: AlbumDomainModel,
        status: Result.Status,
        message: String?,
    ): AlbumModel {
        return AlbumModel(
            id = it.id,
            name = it.name,
            artistNames = it.artistNames,
            tracks = it.tracks?.map { t -> convertToTrackViewModel(Result(status, t, message)).data }
                ?: emptyList(),
            releaseDate = it.releaseDate,
            totalTracks = it.totalTracks,
            externalUrl = it.externalUrl.spotifyUrl,
            imageUrl = it.images.firstOrNull()?.url,
            copyright = it.copyright.joinToString(),
            isFavorite = it.isFavorite
        )
    }

    fun makeArtistModel(it: ArtistDomainModel): ArtistModel {
        return ArtistModel(
            id = it.id,
            name = it.name,
            externalUrl = it.externalUrlDomainModel.spotifyUrl,
            imageUrl = it.imageUrl
        )
    }
}