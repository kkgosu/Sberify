package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sberify.data.DbConverter
import com.example.sberify.data.ResponseConverter
import com.example.sberify.data.Result
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.models.newdomain.AlbumDomainModel
import com.example.sberify.models.newdomain.ArtistDomainModel
import com.example.sberify.models.newdomain.TrackDomainModel
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult
import javax.inject.Inject

class SpotifyRepository @Inject constructor(
    private val database: AppDatabase,
    private val spotifyApi: ISpotifyApi,
    private val dbConverter: DbConverter,
    private val responseConverter: ResponseConverter
) : ISpotifyRepository {

    override fun getNewReleases(): LiveData<Result<List<AlbumDomainModel>>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAllAlbums().map {
                    it.map(dbConverter::convertAlbumEntityToDomain)
                }
            },
            networkCall = { getResult { spotifyApi.getNewReleases() } },
            saveCallResult = { response ->
                val albumAndArtists = response.albums.items.map(responseConverter::convertAlbumToEntity)
                albumAndArtists.forEach {
                    database.getAlbumDao().insertAlbum(it.albumInfo)
                    it.artists.forEach(database.getArtistDao()::insertArtist)
                    it.tracks.forEach(database.getTrackDao()::insertTrack)
                }
            })
    }

    override fun getAlbumInfo(id: String): LiveData<Result<AlbumDomainModel>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAlbumById(id).map {
                    dbConverter.convertAlbumEntityToDomain(it)
                }
            },
            networkCall = { getResult { spotifyApi.getAlbumInfo(id) } },
            saveCallResult = {
                val albumWithTracksAndArtists = responseConverter.convertAlbumToEntity(it)
                database.getAlbumDao().insertAlbum(albumWithTracksAndArtists.albumInfo)
                albumWithTracksAndArtists.artists.forEach { artistEntity ->
                    database.getArtistDao().insertArtist(artistEntity)
                }
                albumWithTracksAndArtists.tracks.forEach { tracksEntity ->
                    database.getTrackDao().insertTrack(tracksEntity)
                }
            })

    }

    override fun searchArtist(keyword: String): LiveData<Result<List<ArtistDomainModel>>> {
        return resultLiveData(
            databaseQuery = {
                database.getArtistDao().getArtistByQuery(keyword).map {
                    it.map(dbConverter::convertArtistEntityToDomain)
                }
            },
            networkCall = {
                getResult {
                    spotifyApi.searchArtist(keyword, SearchTypes.ARTIST)
                }
            },
            saveCallResult = {
                val artists = it.items.map(responseConverter::convertArtistToEntity)
                artists.forEach(database.getArtistDao()::insertArtist)
            })
    }

    override fun searchAlbum(keyword: String): LiveData<Result<List<AlbumDomainModel>>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAlbumsByQuery(keyword).map {
                    it.map(dbConverter::convertAlbumEntityToDomain)
                }
            },
            networkCall = { getResult { spotifyApi.searchAlbum(keyword, SearchTypes.ALBUM) } },
            saveCallResult = { response ->
                val albumAndArtists = response.items.map(responseConverter::convertAlbumToEntity)
                albumAndArtists.forEach {
                    database.getAlbumDao().insertAlbum(it.albumInfo)
                    it.artists.forEach(database.getArtistDao()::insertArtist)
                    it.tracks.forEach(database.getTrackDao()::insertTrack)
                }
            })

    }

    override fun searchTrack(keyword: String): LiveData<Result<List<TrackDomainModel>>> {
        return resultLiveData(
            databaseQuery = {
                database.getTrackDao().getTracksByQuery(keyword).map {
                    it.map(dbConverter::convertTrackEntityToDomain)
                }
            },
            networkCall = { getResult { spotifyApi.searchTrack(keyword, SearchTypes.TRACK) } },
            saveCallResult = {
                val tracks = it.items.map(responseConverter::convertTrackToEntity)
                tracks.forEach(database.getTrackDao()::insertTrack)
            })
    }
}