package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Track

interface ISpotifyRepository {
    fun getNewReleases(): LiveData<Result<List<Album>>>
    fun getAlbumInfo(id: String): LiveData<Result<Album>>
    fun searchArtist(keyword: String): LiveData<Result<List<Artist>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<Album>>>
    fun searchTrack(keyword: String): LiveData<Result<List<Track>>>
}