package com.example.sberify.data.db

import com.example.sberify.MockTestUtils.Companion.mockArtistDB
import org.junit.Assert.assertEquals
import org.junit.Test

class ArtistsConverterTest {


    @Test
    fun fromList() {
        val from = listOf(mockArtistDB())
        val result = ListToStringConverter.fromList(from)

        assertEquals(from, ListToStringConverter.fromString(result))
    }

    @Test
    fun fromString() {
        val from = ListToStringConverter.fromList(listOf(mockArtistDB()))
        val result = ListToStringConverter.fromString(from)

        assertEquals(from, ListToStringConverter.fromList(result))
    }
}