package com.example.sberify.presentation.ui.favorite

import androidx.lifecycle.*
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.domain.model.Track
import kotlinx.coroutines.launch

class FavoriteViewModel(private val databaseRepo: IDatabaseRepository) : ViewModel() {

    private val _favorite = MutableLiveData<List<Track>>()
    val favorite: LiveData<List<Track>> = _favorite

    fun loadFavorite() {
        viewModelScope.launch {
            _favorite.postValue(databaseRepo.loadFavoriteTracks())
        }
    }
}