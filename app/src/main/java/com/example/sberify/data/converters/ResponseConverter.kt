package com.example.sberify.data.converters

import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.models.data.spotify.AlbumInfoResponse
import com.example.sberify.models.data.spotify.AlbumTrackArtistResponse
import com.example.sberify.models.data.spotify.ArtistResponse
import com.example.sberify.models.data.spotify.CopyrightResponse
import com.example.sberify.models.data.spotify.ExternalUrlResponse
import com.example.sberify.models.data.spotify.ImageResponse
import com.example.sberify.models.data.spotify.TrackItemResponse
import com.example.sberify.models.domain.AlbumDomainModel
import com.example.sberify.models.domain.ArtistDomainModel
import com.example.sberify.models.domain.CopyrightDomainModel
import com.example.sberify.models.domain.ExternalUrlDomainModel
import com.example.sberify.models.domain.ImageDomainModel
import com.example.sberify.models.domain.TrackDomainModel

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
class ResponseConverter {

    fun convertImageResponseToDomain(response: ImageResponse): ImageDomainModel {
        return ImageDomainModel(
            response.url
        )
    }

    fun convertCopyrightToDomain(response: CopyrightResponse): CopyrightDomainModel {
        return CopyrightDomainModel(
            text = response.text.orEmpty()
        )
    }

    fun convertExternalUrlToDomain(response: ExternalUrlResponse): ExternalUrlDomainModel {
        return ExternalUrlDomainModel(
            spotifyUrl = response.spotify
        )
    }

    fun convertTrackToDomain(response: TrackItemResponse): TrackDomainModel {
        return TrackDomainModel(
            id = response.id,
            name = response.name,
            artistNames = response.artists.joinToString { it.name },
            externalUri = convertExternalUrlToDomain(response.externalUrls),
            explicit = response.explicit ?: false,
            isLocal = response.isLocal ?: false,
            previewUri = response.previewUrl.orEmpty(),
            markets = emptyList(),
            isFavorite = false
        )
    }

    fun convertArtistToDomain(response: ArtistResponse): ArtistDomainModel {
        return ArtistDomainModel(
            id = response.id,
            name = response.name,
            externalUrlDomainModel = convertExternalUrlToDomain(response.externalUrls),
            imageUrl = response.images?.firstOrNull()?.url,
            popularity = response.popularity
        )
    }

    fun convertAlbumToDomain(response: AlbumInfoResponse): AlbumDomainModel {
        return AlbumDomainModel(
            id = response.id,
            name = response.name,
            artistNames = response.artists?.joinToString { it.name }.orEmpty(),
            tracks = response.tracks?.items?.map(this::convertTrackToDomain) ?: emptyList(),
            genres = response.genres?.map(Any::toString) ?: emptyList(),
            releaseDate = response.releaseDate.orEmpty(),
            totalTracks = response.totalTracks ?: 0,
            externalUrl = convertExternalUrlToDomain(response.externalUrls),
            images = response.images?.map(this::convertImageResponseToDomain) ?: emptyList(),
            copyright = response.copyrights?.map(this::convertCopyrightToDomain) ?: emptyList(),
            markets = response.availableMarkets ?: emptyList(),
            albumType = response.albumType.orEmpty(),
            label = response.label.orEmpty(),
            isFavorite = false
        )
    }

    fun convertAlbumToEntity(response: AlbumInfoResponse): AlbumTrackArtistResponse {
        val album = AlbumEntity(
            spotifyId = response.id,
            artistNames = response.artists?.map { it.name } ?: emptyList(),
            name = response.name,
            imageUrl = response.images?.firstOrNull()?.url.orEmpty(),
            releaseDate = response.releaseDate.orEmpty(),
            isFavorite = false,
            genres = response.genres?.map(Any::toString) ?: emptyList(),
            totalTracks = response.totalTracks ?: response.tracks?.total ?: 0,
            externalUrl = response.externalUrls.spotify,
            copyrights = response.copyrights?.map { it.text.orEmpty() } ?: emptyList(),
            markets = response.availableMarkets?.map { it } ?: emptyList(),
            type = response.type.orEmpty(),
            label = response.label.orEmpty()
        )
        val artists = response.artists?.map(this::convertArtistToEntity) ?: emptyList()
        val tracks = response.tracks?.items?.map {
            TrackEntity(
                spotifyId = it.id,
                name = it.name,
                artistNames = it.artists.joinToString { ar -> ar.name },
                albumId = response.id,
                lyrics = null,
                artistsId = it.artists.map { artist -> artist.id },
                isFavorite = false,
                imageUrl = response.images?.firstOrNull()?.url.orEmpty(),
                externalUrl = it.externalUrls.spotify,
                isExplicit = it.explicit ?: false,
                isLocal = it.isLocal ?: false,
                markets = it.availableMarkets ?: emptyList()

            )
        } ?: emptyList()
        return AlbumTrackArtistResponse(
            album,
            artists,
            tracks
        )
    }

    fun convertTrackToEntity(response: TrackItemResponse): TrackEntity {
        return TrackEntity(
            spotifyId = response.id,
            name = response.name,
            artistNames = response.artists.joinToString { it.name },
            albumId = null,
            lyrics = null,
            artistsId = response.artists.map { artist -> artist.id },
            isFavorite = false,
            imageUrl = "",
            externalUrl = response.externalUrls.spotify,
            isExplicit = response.explicit ?: false,
            isLocal = response.isLocal ?: false,
            markets = response.availableMarkets ?: emptyList()
        )
    }

    fun convertArtistToEntity(response: ArtistResponse) = ArtistEntity(
        spotifyId = response.id,
        name = response.name,
        imageUrl = response.images?.firstOrNull()?.url.orEmpty(),
        externalUrl = response.externalUrls.spotify,
        popularity = response.popularity
    )
}