package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sberify.data.DataConverter
import com.example.sberify.data.Result
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult
import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Track
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.album.AlbumEntity
import com.kvlg.shared.data.db.artists.ArtistEntity
import com.kvlg.shared.data.db.track.TrackEntity
import javax.inject.Inject

class SpotifyRepository @Inject constructor(
    private val dataConverter: DataConverter,
    private val database: AppDatabase,
    private val mSpotifyApi: ISpotifyApi
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

    override fun searchArtist(keyword: String): LiveData<Result<List<Artist>>> {
        return resultLiveData(
            databaseQuery = {
                database.getArtistDao().getArtistByKeyword(keyword).map {
                    it.map { entity -> entity.toArtist() }
                }
            },
            networkCall = {
                getResult {
                    mSpotifyApi.searchArtist(keyword, SearchTypes.ARTIST)
                }
            },
            saveCallResult = {
                val artists = dataConverter.convertArtists(it.artists.items)
                artists.forEach { artist ->
                    database.getArtistDao()
                        .insertArtist(ArtistEntity.from(artist))
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

    override fun searchTrack(keyword: String): LiveData<Result<List<Track>>> {
        return resultLiveData(
            databaseQuery = {
                database.getTrackDao().getTracksByKeyword(keyword).map {
                    it.map { entity -> entity.toTrack() }
                }
            },
            networkCall = { getResult { mSpotifyApi.searchTrack(keyword, SearchTypes.TRACK) } },
            saveCallResult = {
                val tracks = dataConverter.convertTracks(it.tracks.items, "")
                tracks?.forEach { track ->
                    database.getTrackDao().insertTrack(TrackEntity.from(track))
                }
            })
    }
}