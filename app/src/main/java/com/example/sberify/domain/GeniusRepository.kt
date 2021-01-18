package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result
import com.kvlg.spotify_api.models.domain.RawTrackModel

interface GeniusRepository {
    suspend fun getLyrics(track: RawTrackModel): LiveData<Result<RawTrackModel?>>
}