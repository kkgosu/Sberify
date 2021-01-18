package com.kvlg.genius_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.genius_api.GeniusApi
import com.kvlg.genius_impl.data.GeniusRepository
import com.kvlg.spotify_api.converter.ViewModelConverter
import com.kvlg.spotify_models.presentation.TrackModel

class GeniusApiImpl(
    private val repo: GeniusRepository,
    private val modelConverter: ViewModelConverter
) : GeniusApi {

    override suspend fun getLyrics(track: RawTrackModel): LiveData<Result<TrackModel?>> {
        return repo.getLyrics(track).map(modelConverter::convertToTrackViewModel)
    }
}