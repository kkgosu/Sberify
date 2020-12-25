package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.domain.AlbumDomainModel
import com.example.sberify.models.domain.ArtistDomainModel
import com.example.sberify.models.domain.TrackDomainModel

interface SpotifyRepository {
    fun getNewReleases(): LiveData<Result<List<AlbumDomainModel>>>
    fun getAlbumInfo(id: String): LiveData<Result<AlbumDomainModel>>
    fun searchArtist(keyword: String): LiveData<Result<List<ArtistDomainModel>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<AlbumDomainModel>>>
    fun searchTrack(keyword: String): LiveData<Result<List<TrackDomainModel>>>
}