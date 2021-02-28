package com.kvlg.lyrics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.core_utils.Result
import com.kvlg.core_utils.models.RawTrackModel
import com.kvlg.genius_api.GeniusApi
import com.kvlg.spotify_common.presentation.TrackModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LyricsViewModel @ViewModelInject constructor(
    private val geniusApi: GeniusApi,
    private val databaseRepository: DatabaseRepository
) : ViewModel() {

    private val lyricsTrigger = MutableLiveData<RawTrackModel>()

    val lyrics: LiveData<Result<TrackModel?>> = Transformations.switchMap(lyricsTrigger) {
        liveData(Dispatchers.IO) {
            try {
                emit(Result.loading())
                emitSource(geniusApi.interactor().getLyrics(it))
            } catch (e: Exception) {
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

    fun updateTrack(track: TrackModel) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            databaseRepository.setTrackIsFavorite(track.id, track.isFavorite)
        }
    }
}