package com.example.sberify.presentation.ui.lyrics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.DatabaseRepository
import com.kvlg.spotify.models.presentation.TrackModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LyricsViewModel @ViewModelInject constructor(
    private val databaseRepository: DatabaseRepository
) : ViewModel() {

    fun updateTrack(track: TrackModel) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            databaseRepository.setTrackIsFavorite(track.id, track.isFavorite)
        }
    }
}