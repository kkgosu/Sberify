package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.kvlg.model.presentation.Track

interface IGeniusRepository {
    suspend fun getLyrics(track: Track): LiveData<Result<Track>>
}