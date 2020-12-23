package com.example.sberify.data

import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.domain.getDateFromString
import com.example.sberify.models.newdomain.AlbumDomainModel
import com.example.sberify.models.newdomain.ArtistDomainModel
import com.example.sberify.models.newdomain.CopyrightDomainModel
import com.example.sberify.models.newdomain.ExternalUrlDomainModel
import com.example.sberify.models.newdomain.ImageDomainModel
import com.example.sberify.models.newdomain.TrackDomainModel
import timber.log.Timber

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
class DbConverter {

    fun convertArtistEntityToDomain(artistEntity: ArtistEntity): ArtistDomainModel {
        Timber.d("convertArtistEntityToDomain() ${artistEntity.name}")
        return ArtistDomainModel(
            id = artistEntity.spotifyId,
            name = artistEntity.name,
            imageUrl = artistEntity.imageUrl,
            externalUrlDomainModel = ExternalUrlDomainModel(artistEntity.externalUrl),
        )
    }

    fun convertTrackEntityToDomain(trackEntity: TrackEntity): TrackDomainModel {
        return TrackDomainModel(
            id = trackEntity.spotifyId,
            name = trackEntity.name,
            artistNames = trackEntity.artistNames,
            externalUri = ExternalUrlDomainModel(trackEntity.externalUrl),
            explicit = trackEntity.isExplicit,
            isLocal = trackEntity.isLocal,
            previewUri = trackEntity.imageUrl.orEmpty(),
            markets = trackEntity.markets,
            isFavorite = trackEntity.isFavorite,
            lyrics = trackEntity.lyrics
        )
    }

    fun convertAlbumEntityToDomain(
        albumEntity: AlbumEntity,
        tracksEntities: List<TrackEntity>? = null
    ): AlbumDomainModel {
        return AlbumDomainModel(
            id = albumEntity.spotifyId,
            name = albumEntity.name,
            artistNames = albumEntity.artistNames.joinToString(),
            tracks = tracksEntities?.map(this::convertTrackEntityToDomain),
            genres = albumEntity.genres,
            releaseDate = getDateFromString(albumEntity.releaseDate, albumEntity.releaseDatePrecision),
            totalTracks = albumEntity.totalTracks,
            externalUrl = ExternalUrlDomainModel(albumEntity.externalUrl),
            images = listOf(ImageDomainModel(albumEntity.imageUrl)),
            copyright = albumEntity.copyrights.map { CopyrightDomainModel(it) },
            markets = albumEntity.markets,
            albumType = albumEntity.type,
            label = albumEntity.label,
            isFavorite = albumEntity.isFavorite
        )
    }

}