package com.example.sberify.domain

import com.example.sberify.domain.model.Track

interface IGeniusRepository {
    suspend fun getLyrics(track: Track): String
}