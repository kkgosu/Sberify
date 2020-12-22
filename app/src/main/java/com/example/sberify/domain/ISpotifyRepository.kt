package com.example.sberify.domain

import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.newdomain.AlbumArtistsDomainModel
import com.example.sberify.models.newdomain.AlbumDomainModel
import com.example.sberify.models.newdomain.ArtistDomainModel
import com.example.sberify.models.newdomain.TrackDomainModel

interface ISpotifyRepository {
    fun getNewReleases(): LiveData<Result<List<AlbumArtistsDomainModel>>>
    fun getAlbumInfo(id: String): LiveData<Result<AlbumDomainModel>>
    fun searchArtist(keyword: String): LiveData<Result<List<ArtistDomainModel>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<AlbumArtistsDomainModel>>>
    fun searchTrack(keyword: String): LiveData<Result<List<TrackDomainModel>>>
}