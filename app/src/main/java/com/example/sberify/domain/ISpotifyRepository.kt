package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Token
import com.example.sberify.models.domain.Track

interface ISpotifyRepository {
    fun getToken(): LiveData<Token>
    fun getNewReleases(): LiveData<Result<List<Album>>>
    fun getAlbumInfo(id: String): LiveData<Result<Album>>
    fun searchArtist(keyword: String): LiveData<Result<List<Artist>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<Album>>>
    fun searchTrack(keyword: String): LiveData<Result<List<Track>>>
}