package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel

interface GeniusRepository {
    suspend fun getLyrics(track: RawTrackModel): LiveData<Result<RawTrackModel?>>
}