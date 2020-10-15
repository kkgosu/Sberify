package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Track

interface IGeniusRepository {
    suspend fun getKendrikLamar(): String
    fun getLyrics(track: Track): LiveData<Result<Track>>
}