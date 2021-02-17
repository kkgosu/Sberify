package com.kvlg.genius_impl.data

import androidx.lifecycle.LiveData
import com.kvlg.core.Result
import com.kvlg.core.models.RawTrackModel
import com.kvlg.spotify_models.domain.TrackDomainModel

/**
 * @author Konstantin Koval
 * @since 18.01.2021
 */
internal interface GeniusRepository {
    suspend fun getLyrics(track: RawTrackModel): LiveData<Result<TrackDomainModel?>>
}