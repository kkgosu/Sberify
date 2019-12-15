package com.example.sberify.data.db

import com.example.sberify.MockTestUtils.Companion.mockTrackDB
import org.junit.Assert.assertEquals
import org.junit.Test

class TrackIdConverterTest {

    @Test
    fun fromList() {
        val from = listOf(mockTrackDB())
        val result = TrackIdConverter.fromList(from)

        assertEquals(from, TrackIdConverter.fromString(result))
    }

    @Test
    fun fromString() {
        val from = TrackIdConverter.fromList(listOf(mockTrackDB()))!!
        val result = TrackIdConverter.fromString(from)!!

        assertEquals(from, TrackIdConverter.fromList(result))
    }
}