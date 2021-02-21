package com.kvlg.lyrics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kvlg.core_db.DatabaseRepository
import com.kvlg.spotify_common.presentation.TrackModel
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