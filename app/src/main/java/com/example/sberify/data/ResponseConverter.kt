package com.example.sberify.data

import com.example.sberify.models.newdata.*
import com.example.sberify.models.newdomain.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
class ResponseConverter {

    fun convertImageResponseToDomain(response: ImageResponse): ImageDomainModel {
        return ImageDomainModel(
            response.height,
            response.width
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
            uri = response.uri,
            externalUrlDomainModel = convertExternalUrlToDomain(response.externalUrls)
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

    private fun getDateFromString(stringDate: String, precision: String): Date {
        if (stringDate.isNotEmpty() && precision.isNotEmpty()) {
            val sdfDay = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val sdfMonth = SimpleDateFormat("yyyy-MM", Locale.getDefault())
            val sdfYear = SimpleDateFormat("yyyy", Locale.getDefault())
            return try {
                when (precision) {
                    "day" -> sdfDay.parse(stringDate)
                    "month" -> sdfMonth.parse(stringDate)
                    "year" -> sdfYear.parse(stringDate)
                    else -> Date()
                }
            } catch (e: ParseException) {
                Date()
            }
        } else {
            return Date()
        }
    }
}