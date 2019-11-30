package com.example.sberify.presentation.ui.lyrics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.model.Track
import kotlinx.coroutines.launch

class LyricsViewModel(private val databaseRepository: IDatabaseRepository) : ViewModel() {
    
    fun updateTrack(track: Track) {
        viewModelScope.launch {
            databaseRepository.updateTrack(track)
        }
    }
}