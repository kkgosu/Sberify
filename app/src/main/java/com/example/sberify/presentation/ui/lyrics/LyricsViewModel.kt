package com.example.sberify.presentation.ui.lyrics

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IDatabaseRepository
import com.kvlg.model.presentation.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LyricsViewModel @ViewModelInject constructor(
    private val databaseRepository: IDatabaseRepository
) : ViewModel() {

    fun updateTrack(track: Track) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(800)
            databaseRepository.updateTrack(track)
        }
    }
}