package com.example.sberify.presentation.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sberify.domain.IDatabaseRepository
import com.example.sberify.models.domain.Track
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
        private val databaseRepo: IDatabaseRepository) : ViewModel() {

    private val reloadTrigger = MutableLiveData<Boolean>()

    val favorite: LiveData<List<Track>> = Transformations.switchMap(reloadTrigger) {
        println("FavoriteViewModel.")
        databaseRepo.loadFavoriteTracks()
    }

    fun loadFavorite() {
        println("FavoriteViewModel.loadFavorite")
        reloadTrigger.value = true
    }
}