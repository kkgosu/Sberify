package com.example.sberify.domain

import com.example.sberify.models.domain.Track

interface IGeniusRepository {
    suspend fun getLyrics(track: Track): String
}