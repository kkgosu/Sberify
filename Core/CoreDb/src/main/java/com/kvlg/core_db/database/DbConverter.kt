package com.kvlg.core_db.database

import com.kvlg.spotify_common.domain.AlbumDomainModel
import com.kvlg.spotify_common.domain.ArtistDomainModel
import com.kvlg.spotify_common.domain.CopyrightDomainModel
import com.kvlg.spotify_common.domain.ExternalUrlDomainModel
import com.kvlg.spotify_common.domain.ImageDomainModel
import com.kvlg.spotify_common.domain.TrackDomainModel
import com.kvlg.spotify_common.entity.AlbumEntity
import com.kvlg.spotify_common.entity.ArtistEntity
import com.kvlg.spotify_common.entity.TrackEntity

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
            popularity = artistEntity.popularity
        )
    }

    fun convertTrackEntityToDomain(trackEntity: TrackEntity): TrackDomainModel {
        return TrackDomainModel(
            id = trackEntity.spotifyId,
            name = trackEntity.name,
            artistNames = trackEntity.artistNames,
            explicit = trackEntity.isExplicit,
            previewUri = trackEntity.imageUrl.orEmpty(),
            isFavorite = trackEntity.isFavorite,
            lyrics = trackEntity.lyrics,
            uri = trackEntity.uri
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
            releaseDate = albumEntity.releaseDate,
            totalTracks = albumEntity.totalTracks,
            externalUrl = ExternalUrlDomainModel(albumEntity.externalUrl),
            images = listOf(ImageDomainModel(albumEntity.imageUrl)),
            copyright = albumEntity.copyrights.map(::CopyrightDomainModel),
            markets = albumEntity.markets,
            albumType = albumEntity.type,
            label = albumEntity.label,
            isFavorite = albumEntity.isFavorite
        )
    }

}