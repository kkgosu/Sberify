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

/**
 * @author Konstantin Koval
 * @since 07.12.2020
 */
class DbConverter {

    fun convertArtistEntityToDomain(artistEntity: ArtistEntity): ArtistDomainModel {
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
            artists = trackEntity.artistsId.map(this::convertArtistEntityToDomain),
            externalUri = ExternalUrlDomainModel(trackEntity.externalUrl),
            explicit = trackEntity.isExplicit,
            isLocal = trackEntity.isLocal,
            previewUri = trackEntity.image_url.orEmpty(),
            markets = trackEntity.markets
        )
    }

    fun convertAlbumEntityToDomain(albumEntity: AlbumEntity, tracksEntities: List<TrackEntity>? = null): AlbumDomainModel {
        return AlbumDomainModel(
            id = albumEntity.spotifyId,
            name = albumEntity.name,
            tracks = tracksEntities?.map(this::convertTrackEntityToDomain),
            genres = albumEntity.genres,
            releaseDate = getDateFromString(albumEntity.releaseDate, albumEntity.releaseDatePrecision),
            totalTracks = albumEntity.totalTracks,
            externalUrl = ExternalUrlDomainModel(albumEntity.externalUrlTracks),
            images = listOf(ImageDomainModel(albumEntity.imageUrl)),
            copyright = albumEntity.copyrights.map { CopyrightDomainModel(it) },
            markets = albumEntity.markets,
            albumType = albumEntity.type,
            label = albumEntity.label
        )
    }


}