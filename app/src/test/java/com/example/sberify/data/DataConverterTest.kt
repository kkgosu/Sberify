package com.example.sberify.data

import com.example.sberify.MockTestUtils.Companion.mockAlbum
import com.example.sberify.MockTestUtils.Companion.mockAlbumData
import com.example.sberify.MockTestUtils.Companion.mockArtist
import com.example.sberify.MockTestUtils.Companion.mockArtistData
import com.example.sberify.MockTestUtils.Companion.mockImage
import com.example.sberify.MockTestUtils.Companion.mockImageData
import com.example.sberify.MockTestUtils.Companion.mockTrack
import com.example.sberify.MockTestUtils.Companion.mockTrackData
import com.kvlg.network.spotify.DataConverter
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DataConverterTest {

    private val converter = DataConverter()

    @Test
    fun convertAlbums() {
        val from = listOf(mockAlbumData())
        val result = listOf(mockAlbum())

        assertEquals(result, converter.convertAlbums(from))
        assertNotEquals(from, converter.convertAlbums(from))
        assertNotNull(converter.convertAlbums(null))
    }

    @Test
    fun convertArtists() {
        val from = listOf(mockArtistData())
        val result = listOf(mockArtist())

        assertEquals(result, converter.convertArtists(from))
        assertNotEquals(from, converter.convertArtists(from))
        assertNotNull(converter.convertArtists(emptyList()))
    }

    @Test
    fun convertTracks() {
        val from = listOf(mockTrackData())
        val result = listOf(mockTrack())

        assertEquals(result, converter.convertTracks(from, ""))
        assertNotEquals(from, converter.convertTracks(from, ""))
        assertNull(converter.convertTracks(null, ""))
    }

    @Test
    fun convertImages() {
        val from = mockImageData()
        val result = mockImage()

        assertEquals(result, converter.convertImages(from))
        assertNotEquals(from, converter.convertImages(from))
        assertNull(converter.convertImages(null))
    }
}