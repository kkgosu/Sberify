package com.kvlg.spotify_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.kvlg.core_utils.Result
import com.kvlg.spotify_api.api.SpotifyInteractor
import com.kvlg.spotify_api.converter.ViewModelConverter
import com.kvlg.spotify_impl.data.SpotifyRepository
import com.kvlg.spotify_models.presentation.AlbumModel
import com.kvlg.spotify_models.presentation.ArtistModel
import com.kvlg.spotify_models.presentation.TrackModel

class SpotifyInteractorImpl(
    private val repo: SpotifyRepository,
    private val modelConverter: ViewModelConverter
) : SpotifyInteractor {

    override fun getNewReleases(): LiveData<Result<List<AlbumModel>>> {
        return repo.getNewReleases().map(modelConverter::convertToAlbumViewModelList)
    }

    override fun getAlbumInfo(id: String): LiveData<Result<AlbumModel>> {
        return repo.getAlbumInfo(id).map(modelConverter::convertToAlbumViewModel)
    }

    override fun searchArtist(keyword: String): LiveData<Result<List<ArtistModel>>> {
        return repo.searchArtist(keyword).map(modelConverter::convertToArtistViewModelList)
    }

    override fun searchAlbum(keyword: String): LiveData<Result<List<AlbumModel>>> {
        return repo.searchAlbum(keyword).map(modelConverter::convertToAlbumViewModelList)
    }

    override fun searchTrack(keyword: String): LiveData<Result<List<TrackModel>>> {
        return repo.searchTrack(keyword).map(modelConverter::convertToTrackViewModelList)
    }
}