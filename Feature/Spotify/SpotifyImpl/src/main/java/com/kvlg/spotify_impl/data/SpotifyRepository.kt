package com.kvlg.spotify_impl.data

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result
import com.kvlg.spotify_common.domain.AlbumDomainModel
import com.kvlg.spotify_common.domain.ArtistDomainModel
import com.kvlg.spotify_common.domain.TrackDomainModel

internal interface SpotifyRepository {
    fun getNewReleases(): LiveData<Result<List<AlbumDomainModel>>>
    fun getAlbumInfo(id: String): LiveData<Result<AlbumDomainModel>>
    fun searchArtist(keyword: String): LiveData<Result<List<ArtistDomainModel>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<AlbumDomainModel>>>
    fun searchTrack(keyword: String): LiveData<Result<List<TrackDomainModel>>>
    suspend fun getToken(): String
}