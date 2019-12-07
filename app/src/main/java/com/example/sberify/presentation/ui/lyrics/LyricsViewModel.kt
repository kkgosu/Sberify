package com.example.sberify.presentation.ui.lyrics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.models.domain.Track
import kotlinx.coroutines.launch
import javax.inject.Inject

class LyricsViewModel @Inject constructor(
        private val databaseRepository: IDatabaseRepository) : ViewModel() {
    
    fun updateTrack(track: Track) {
        viewModelScope.launch {
            databaseRepository.updateTrack(track)
        }
    }
}