package com.kvlg.genius_api

import androidx.lifecycle.LiveData
import com.kvlg.core.Result
import com.kvlg.core.models.RawTrackModel
import com.kvlg.spotify_models.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 27.01.2021
 */
interface GeniusInteractor {
    suspend fun getLyrics(track: RawTrackModel): LiveData<Result<TrackModel?>>
}