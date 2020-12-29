package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.domain.TrackDomainModel

interface GeniusRepository {
    suspend fun getLyrics(track: TrackDomainModel): LiveData<Result<TrackDomainModel?>>
}