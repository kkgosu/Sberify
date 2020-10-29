package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Album
import com.kvlg.network.spotify.DataConverter
import com.kvlg.network.spotify.SearchTypes
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.album.AlbumEntity
import com.kvlg.shared.data.db.artists.ArtistEntity
import com.kvlg.shared.domain.resultLiveData
import javax.inject.Inject

class SpotifyRepository @Inject constructor(
    private val dataConverter: DataConverter,
    private val database: AppDatabase,
    private val mSpotifyApi: SpotifyApi
) : ISpotifyRepository {


    override fun getNewReleases(): LiveData<Result<List<Album>>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAlbums().map {
                    it.map { enitity -> enitity.toAlbum() }
                }
            },
            networkCall = { getResult { mSpotifyApi.getNewReleases() } },
            saveCallResult = {
                val albums = dataConverter.convertAlbums(it.albums.items)
                albums.forEach { album ->
                    database.getArtistDao().insertArtist(ArtistEntity.from(album.artist))
                    database.getAlbumDao().insertAlbum(AlbumEntity.from(album))
                }
            })
    }

    override fun getAlbumInfo(id: String): LiveData<Result<Album>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAlbumById(id).map {
                    it.toAlbum()
                }
            },
            networkCall = { getResult { mSpotifyApi.getAlbumInfo(id) } },
            saveCallResult = {
                val albumInfo = dataConverter.convertAlbums(listOf(it))
                albumInfo.forEach { album ->
                    database.getAlbumDao()
                        .updateAlbumTracks(album.id, album.tracks!!)
                }
            })

    }

    override fun searchAlbum(keyword: String): LiveData<Result<List<Album>>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAlbumsByKeyword(keyword).map {
                    it.map { entity -> entity.toAlbum() }
                }
            },
            networkCall = { getResult { mSpotifyApi.searchAlbum(keyword, SearchTypes.ALBUM) } },
            saveCallResult = {
                val albums = dataConverter.convertAlbums(it.albums.items)
                albums.forEach { album ->
                    database.getAlbumDao().insertAlbum(AlbumEntity.from(album))
                }
            })

    }
}