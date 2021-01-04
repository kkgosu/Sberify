package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.domain.RawTrackDomainModel
import com.example.sberify.models.domain.TrackDomainModel
import com.example.sberify.models.presentation.TrackModel

interface GeniusRepository {
    suspend fun getLyrics(track: RawTrackDomainModel): LiveData<Result<TrackDomainModel?>>
}