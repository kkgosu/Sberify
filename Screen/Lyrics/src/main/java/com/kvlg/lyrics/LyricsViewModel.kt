package com.kvlg.lyrics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.kvlg.analytics.AnalyticsInteractor
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.genius_api.GeniusApi
import com.kvlg.shared.di.IoDispatcher
import com.kvlg.spotify_common.presentation.TrackModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LyricsViewModel @ViewModelInject constructor(
    private val geniusApi: GeniusApi,
    private val databaseRepository: DatabaseRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val analyticsInteractor: AnalyticsInteractor,
) : ViewModel() {

    private val lyricsTrigger = MutableLiveData<RawTrackModel>()

    val lyrics: LiveData<Result<TrackModel?>> = Transformations.switchMap(lyricsTrigger) {
        liveData(dispatcher) {
            try {
                emit(Result.loading())
                emitSource(geniusApi.interactor().getLyrics(it))
            } catch (e: Exception) {
                emit(Result.error(e.message ?: "error on loading lyrics"))
                emitSource(MutableLiveData())
            }
        }
    }

    fun getLyrics(track: TrackModel) {
        lyricsTrigger.value = RawTrackModel(
            id = track.id,
            name = track.name,
            artistNames = track.artistNames
        )
    }

    fun setFavoriteTrack(track: TrackModel) {
        viewModelScope.launch(dispatcher) {
            analyticsInteractor.addFavoriteTrack()
            delay(800)
            databaseRepository.setTrackIsFavorite(track.id, track.isFavorite)
        }
    }
}