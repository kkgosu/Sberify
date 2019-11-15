package com.example.sberify.domain

interface IGeniusRepository {
    suspend fun getLyrics(trackUrl: String): String
}