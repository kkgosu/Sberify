package com.example.sberify.data

import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.domain.getDateFromString
import com.example.sberify.models.newdata.AlbumInfoResponse
import com.example.sberify.models.newdata.AlbumTrackArtistResponse
import com.example.sberify.models.newdata.ArtistResponse
import com.example.sberify.models.newdata.CopyrightResponse
import com.example.sberify.models.newdata.ExternalUrlResponse
import com.example.sberify.models.newdata.ImageResponse
import com.example.sberify.models.newdata.TrackItemResponse
import com.example.sberify.models.newdomain.AlbumDomainModel
import com.example.sberify.models.newdomain.ArtistDomainModel
import com.example.sberify.models.newdomain.CopyrightDomainModel
import com.example.sberify.models.newdomain.ExternalUrlDomainModel
import com.example.sberify.models.newdomain.ImageDomainModel
import com.example.sberify.models.newdomain.TrackDomainModel

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
            artists = response.artists.map(this::convertArtistToDomain),
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
            imageUrl = null
        )
    }

    fun convertAlbumToDomain(response: AlbumInfoResponse): AlbumDomainModel {
        return AlbumDomainModel(
            id = response.id,
            name = response.name,
            tracks = response.tracks?.items?.map(this::convertTrackToDomain) ?: emptyList(),
            genres = response.genres?.map(Any::toString) ?: emptyList(),
            releaseDate = getDateFromString(response.releaseDate.orEmpty(), response.releaseDatePrecision.orEmpty()),
            totalTracks = response.totalTracks ?: 0,
            externalUrl = convertExternalUrlToDomain(response.externalUrls),
            images = response.images?.map(this::convertImageResponseToDomain) ?: emptyList(),
            copyright = response.copyrights?.map(this::convertCopyrightToDomain) ?: emptyList(),
            markets = response.availableMarkets ?: emptyList(),
            albumType = response.albumType.orEmpty(),
            label = response.label.orEmpty()
        )
    }

    fun convertAlbumToEntity(response: AlbumInfoResponse): AlbumTrackArtistResponse {
        val dateFromString = getDateFromString(response.releaseDate.orEmpty(), response.releaseDatePrecision.orEmpty())
        val album = AlbumEntity(
            spotifyId = response.id,
            artistIds = response.artists?.map { it.id } ?: emptyList(),
            name = response.name,
            imageUrl = response.images?.firstOrNull()?.url.orEmpty(),
            releaseDate = dateFromString.date.toString(),
            releaseDatePrecision = dateFromString.precision.name,
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
                albumId = response.id,
                lyrics = null,
                artistsId = artists.map { artist -> artist.spotifyId },
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
        externalUrl = response.externalUrls.spotify
    )
}