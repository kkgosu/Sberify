package com.example.sberify.presentation.ui.lyrics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IDatabaseRepository
import com.kvlg.model.presentation.Track
import com.kvlg.shared.domain.lyrics.GetLyricsUseCase
import com.kvlg.shared.domain.lyrics.ParseLyricsFromGeniusUseCase
import com.kvlg.shared.domain.resultData
import com.kvlg.shared.domain.track.TrackUseCasesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LyricsViewModel @ViewModelInject constructor(
    private val databaseRepository: IDatabaseRepository,
    trackProvider: TrackUseCasesProvider,
    getLyricsUseCase: GetLyricsUseCase,
    parseLyricsFromGeniusUseCase: ParseLyricsFromGeniusUseCase,
) : ViewModel() {

    private val trigger = MutableLiveData<Track>()

    val lyrics = trigger.switchMap { track ->
        resultData(
            databaseQuery = { getLyricsUseCase(track) },
            networkCall = { parseLyricsFromGeniusUseCase(track) },
            saveCallResult = { trackProvider.saveTrackIntoDb(track) }
        )
    }

    fun getLyrics(track: Track) {
        trigger.value = track
    }

    fun updateTrack(track: Track) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            databaseRepository.updateTrack(track)
        }
    }
}