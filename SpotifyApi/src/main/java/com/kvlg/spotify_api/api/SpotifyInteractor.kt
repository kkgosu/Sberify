package com.kvlg.spotify_api.api

import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result
import com.kvlg.spotify_models.presentation.AlbumModel
import com.kvlg.spotify_models.presentation.ArtistModel
import com.kvlg.spotify_models.presentation.TrackModel

/**
 * @author Konstantin Koval
 * @since 28.01.2021
 */
interface SpotifyInteractor {
    fun getNewReleases(): LiveData<Result<List<AlbumModel>>>
    fun getAlbumInfo(id: String): LiveData<Result<AlbumModel>>
    fun searchArtist(keyword: String): LiveData<Result<List<ArtistModel>>>
    fun searchAlbum(keyword: String): LiveData<Result<List<AlbumModel>>>
    fun searchTrack(keyword: String): LiveData<Result<List<TrackModel>>>
}