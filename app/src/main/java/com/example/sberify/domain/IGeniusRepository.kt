package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.kvlg.model.presentation.Track
import com.kvlg.shared.Result

interface IGeniusRepository {
    suspend fun getLyrics(track: Track): LiveData<Result<Track>>
}