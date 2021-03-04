package com.kvlg.core_db.database

import com.kvlg.spotify_common.domain.AlbumDomainModel
import com.kvlg.spotify_common.domain.ArtistDomainModel
import com.kvlg.spotify_common.domain.CopyrightDomainModel
import com.kvlg.spotify_common.domain.ExternalUrlDomainModel
import com.kvlg.spotify_common.domain.ImageDomainModel
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author Konstantin Koval
 * @since 04.03.2021
 */
class DbConverterTest {

    private val converter = DbConverter()

    @Test
    fun convertArtistEntityToDomain() {
        val expected = ArtistDomainModel(
            id = "artistId1",
            name = "ArtistName",
            externalUrlDomainModel = ExternalUrlDomainModel("externalUrl"),
            imageUrl = "url",
            popularity = 1
        )

        assertEquals(expected, converter.convertArtistEntityToDomain(EntityFactory.getArtistEntity()))
    }

    @Test
    fun convertTrackEntityToDomain() {
        val expected = EntityFactory.getTrackDomainModel()

        assertEquals(expected, converter.convertTrackEntityToDomain(EntityFactory.getTrackEntity()))
    }

    @Test
    fun convertAlbumEntityToDomain() {
        val expected = AlbumDomainModel(
            id = "albumId1",
            artistNames = "ArtistName1, ArtistName2",
            name = "Name",
            releaseDate = "01.01.1970",
            isFavorite = true,
            images = listOf(ImageDomainModel("imageUrl")),
            genres = listOf("Rap"),
            totalTracks = 11,
            copyright = listOf(CopyrightDomainModel("")),
            label = "label",
            externalUrl = ExternalUrlDomainModel("externalUrl"),
            markets = listOf("RU", "NL"),
            tracks = listOf(EntityFactory.getTrackDomainModel()),
            albumType = "Album"
        )

        assertEquals(expected, converter.convertAlbumEntityToDomain(EntityFactory.getAlbumEntity(), listOf(EntityFactory.getTrackEntity())))
    }
}