package com.kvlg.core_db.database

import com.kvlg.spotify_common.domain.ExternalUrlDomainModel
import com.kvlg.spotify_common.domain.TrackDomainModel
import com.kvlg.spotify_common.entity.AlbumEntity
import com.kvlg.spotify_common.entity.ArtistEntity
import com.kvlg.spotify_common.entity.TrackEntity

/**
 * @author Konstantin Koval
 * @since 04.03.2021
 */
object EntityFactory {

    fun getArtistEntity() = ArtistEntity(
        spotifyId = "artistId1",
        name = "ArtistName",
        imageUrl = "url",
        externalUrl = "externalUrl",
        popularity = 1
    )

    fun getTrackEntity() = TrackEntity(
        spotifyId = "trackId1",
        name = "Name",
        albumId = "albumId1",
        artistNames = "ArtistName1, ArtistName2",
        lyrics = "Some Lyrics",
        artistsId = listOf("ArtistId1", "ArtistId2"),
        isFavorite = true,
        imageUrl = "imageUrl",
        externalUrl = "externalUrl",
        isExplicit = true,
        isLocal = true,
        markets = listOf("RU", "NL")
    )

    fun getAlbumEntity() = AlbumEntity(
        spotifyId = "albumId1",
        artistNames = listOf("ArtistName1", "ArtistName2"),
        name = "Name",
        releaseDate = "01.01.1970",
        isFavorite = true,
        imageUrl = "imageUrl",
        genres = listOf("Rap"),
        totalTracks = 11,
        copyrights = listOf(""),
        type = "Album",
        label = "label",
        externalUrl = "externalUrl",
        markets = listOf("RU", "NL")
    )

    fun getTrackDomainModel() = TrackDomainModel(
        id = "trackId1",
        name = "Name",
        artistNames = "ArtistName1, ArtistName2",
        lyrics = "Some Lyrics",
        externalUri = ExternalUrlDomainModel("externalUrl"),
        explicit = true,
        isLocal = true,
        isFavorite = true,
        previewUri = "imageUrl",
        markets = listOf("RU", "NL")
    )
}