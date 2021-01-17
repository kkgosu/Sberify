package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.kvlg.spotify.models.domain.RawTrackDomainModel
import com.kvlg.spotify.models.domain.TrackDomainModel

interface GeniusRepository {
    suspend fun getLyrics(track: RawTrackDomainModel): LiveData<Result<TrackDomainModel?>>
}