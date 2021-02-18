package com.kvlg.genius_api

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.spotify_common.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 27.01.2021
 */
interface GeniusInteractor {
    suspend fun getLyrics(track: RawTrackModel): LiveData<Result<TrackModel?>>
}