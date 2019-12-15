package com.example.sberify.data.db

import com.example.sberify.MockTestUtils.Companion.mockArtistDB
import org.junit.Assert.assertEquals
import org.junit.Test

class ArtistsConverterTest {


    @Test
    fun fromList() {
        val from = listOf(mockArtistDB())
        val result = ArtistsConverter.fromList(from)

        assertEquals(from, ArtistsConverter.fromString(result))
    }

    @Test
    fun fromString() {
        val from = ArtistsConverter.fromList(listOf(mockArtistDB()))
        val result = ArtistsConverter.fromString(from)

        assertEquals(from, ArtistsConverter.fromList(result))
    }
}