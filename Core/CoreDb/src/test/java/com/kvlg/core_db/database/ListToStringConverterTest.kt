package com.kvlg.core_db.database

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author Konstantin Koval
 * @since 04.03.2021
 */
class ListToStringConverterTest {

    @Test
    fun fromList() {
        val expected = "String, string"
        assertEquals(expected, ListToStringConverter.fromList(listOf("String", "string")))
    }

    @Test
    fun fromList_empty() {
        val expected = ""
        assertEquals(expected, ListToStringConverter.fromList(listOf()))
    }

    @Test
    fun fromString() {
        val expected = listOf("String", "string")
        assertEquals(expected, ListToStringConverter.fromString("String, string"))
    }

    @Test
    fun fromString_empty() {
        val expected = listOf("")
        assertEquals(expected, ListToStringConverter.fromString(""))
    }
}