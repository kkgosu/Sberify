package com.kvlg.genius_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.genius_api.GeniusApi
import com.kvlg.genius_impl.data.GeniusRepository

class GeniusApiImpl(
    private val repo: GeniusRepository,
    private val modelConverter: ViewModelConverter
) : GeniusApi {

    override suspend fun getLyrics(track: RawTrackModel): LiveData<Result<TrackModel?>> {
        return repo.getLyrics(track).map(modelConverter::convertToTrackViewModel)
    }
}