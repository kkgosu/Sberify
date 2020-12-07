package com.example.sberify.data

import com.example.sberify.domain.getDateFromString
import com.example.sberify.models.newdata.AlbumInfoResponse
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
            name = response.name.orEmpty(),
            artists = response.artists?.map(this::convertArtistToDomain) ?: emptyList(),
            externalUri = convertExternalUrlToDomain(response.externalUrls),
            explicit = response.explicit ?: false,
            isLocal = response.isLocal ?: false,
            previewUri = response.previewUrl.orEmpty(),
            markets = emptyList()
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
}