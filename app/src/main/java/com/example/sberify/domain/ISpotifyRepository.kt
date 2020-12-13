package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Track
import com.example.sberify.models.newdomain.AlbumDomainModel
import com.example.sberify.models.newdomain.ArtistDomainModel

interface ISpotifyRepository {
    fun getNewReleases(): LiveData<Result<List<AlbumDomainModel>>>
    fun getAlbumInfo(id: String): LiveData<Result<AlbumDomainModel>>
    fun searchArtist(keyword: String): LiveData<Result<List<ArtistDomainModel>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<Album>>>
    fun searchTrack(keyword: String): LiveData<Result<List<Track>>>
}