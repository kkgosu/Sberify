package com.example.sberify.ui.lyrics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.kvlg.model.presentation.Track
import com.kvlg.shared.domain.lyrics.LyricsUseCasesProvider
import com.kvlg.shared.domain.resultData
import com.kvlg.shared.domain.track.TrackUseCasesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LyricsViewModel @ViewModelInject constructor(
    private val trackProvider: TrackUseCasesProvider,
    private val lyricsProvider: LyricsUseCasesProvider
) : ViewModel() {

    private val trigger = MutableLiveData<Track>()

    val lyrics = trigger.switchMap { track ->
        resultData(
            databaseQuery = { lyricsProvider.getLyrics(track) },
            networkCall = { lyricsProvider.parseLyrics(track) },
            saveCallResult = { trackProvider.saveTrackIntoDb(track) }
        )
    }

    fun getLyrics(track: Track) {
        trigger.value = track
    }

    fun updateTrack(track: Track) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            trackProvider.updateTrackInDb(track)
        }
    }
}