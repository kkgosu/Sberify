package com.kvlg.genius_api

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.spotify_models.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
interface GeniusApi {
    suspend fun getLyrics(track: RawTrackModel): LiveData<Result<TrackModel?>>
}