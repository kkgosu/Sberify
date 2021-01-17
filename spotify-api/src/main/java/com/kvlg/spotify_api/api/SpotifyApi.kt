package com.kvlg.spotify_api.api

import androidx.lifecycle.LiveData
import com.kvlg.spotify_api.models.domain.AlbumDomainModel
import com.kvlg.spotify_api.models.domain.ArtistDomainModel
import com.kvlg.spotify_api.models.domain.TrackDomainModel

interface SpotifyApi {
    fun getNewReleases(): LiveData<Result<List<AlbumDomainModel>>>
    fun getAlbumInfo(id: String): LiveData<Result<AlbumDomainModel>>
    fun searchArtist(keyword: String): LiveData<Result<List<ArtistDomainModel>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<AlbumDomainModel>>>
    fun searchTrack(keyword: String): LiveData<Result<List<TrackDomainModel>>>
}