package com.kvlg.spotify_impl.data.converters

import com.kvlg.spotify_common.domain.AlbumDomainModel
import com.kvlg.spotify_common.domain.ArtistDomainModel
import com.kvlg.spotify_common.domain.CopyrightDomainModel
import com.kvlg.spotify_common.domain.ExternalUrlDomainModel
import com.kvlg.spotify_common.domain.ImageDomainModel
import com.kvlg.spotify_common.domain.TrackDomainModel
import com.kvlg.spotify_common.entity.AlbumEntity
import com.kvlg.spotify_common.entity.ArtistEntity
import com.kvlg.spotify_common.entity.TrackEntity
import com.kvlg.spotify_impl.models.data.AlbumInfoResponse
import com.kvlg.spotify_impl.models.data.AlbumTrackArtistResponse
import com.kvlg.spotify_impl.models.data.ArtistResponse
import com.kvlg.spotify_impl.models.data.CopyrightResponse
import com.kvlg.spotify_impl.models.data.ExternalUrlResponse
import com.kvlg.spotify_impl.models.data.ImageResponse
import com.kvlg.spotify_impl.models.data.TrackItemResponse

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
internal class ResponseConverter {

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
            explicit = response.explicit ?: false,
            previewUri = response.previewUrl.orEmpty(),
            isFavorite = false,
            uri = response.uri
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
                isExplicit = it.explicit ?: false,
                uri = it.uri
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
            isExplicit = response.explicit ?: false,
            uri = response.uri
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