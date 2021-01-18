package com.kvlg.genius_impl.data

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
interface GeniusRepository {
    suspend fun getLyrics(track: RawTrackModel): LiveData<Result<RawTrackModel?>>
}