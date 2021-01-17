package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.kvlg.spotify_api.models.domain.RawTrackDomainModel
import com.kvlg.spotify_api.models.domain.TrackDomainModel

interface GeniusRepository {
    suspend fun getLyrics(track: RawTrackDomainModel): LiveData<Result<TrackDomainModel?>>
}