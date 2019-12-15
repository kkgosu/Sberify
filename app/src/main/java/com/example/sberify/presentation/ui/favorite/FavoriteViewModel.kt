package com.example.sberify.presentation.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.models.domain.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
        private val databaseRepo: IDatabaseRepository) : ViewModel() {

    private val _favorite = MutableLiveData<List<Track>>()
    val favorite: LiveData<List<Track>> = _favorite

    fun loadFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            _favorite.postValue(databaseRepo.loadFavoriteTracks())
        }
    }
}