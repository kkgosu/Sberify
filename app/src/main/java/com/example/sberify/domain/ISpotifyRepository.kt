package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Album

interface ISpotifyRepository {
    fun getNewReleases(): LiveData<Result<List<Album>>>
    fun getAlbumInfo(id: String): LiveData<Result<Album>>
    fun searchAlbum(keyword: String): LiveData<Result<List<Album>>>
}