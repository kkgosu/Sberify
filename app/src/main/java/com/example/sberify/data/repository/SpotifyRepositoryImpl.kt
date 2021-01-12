package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sberify.data.Result
import com.example.sberify.data.api.SpotifyApi
import com.example.sberify.data.converters.DbConverter
import com.example.sberify.data.converters.ResponseConverter
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.SpotifyRepository
import com.example.sberify.models.domain.AlbumDomainModel
import com.example.sberify.models.domain.ArtistDomainModel
import com.example.sberify.models.domain.TrackDomainModel
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult

class SpotifyRepositoryImpl(
    private val database: AppDatabase,
    private val spotifyApi: SpotifyApi,
    private val dbConverter: DbConverter,
    private val responseConverter: ResponseConverter
) : SpotifyRepository {

    override fun getNewReleases(): LiveData<Result<List<AlbumDomainModel>>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAlbums().map {
                    it.map(dbConverter::convertAlbumEntityToDomain)
                }
            },
            networkCall = { getResult { spotifyApi.getNewReleases() } },
            saveCallResult = { response ->
                val albumAndArtists = response.albums.items.map(responseConverter::convertAlbumToEntity)
                albumAndArtists.forEach {
                    database.getAlbumDao().insertAlbum(it.albumInfo)
                }
            })
    }

    override fun getAlbumInfo(id: String): LiveData<Result<AlbumDomainModel>> {
        return resultLiveData(
            databaseQuery = {
                database.getAlbumDao().getAlbumInfo(id).map {
                    dbConverter.convertAlbumEntityToDomain(it.albumEntity, it.tracksEntities)
                }
            },
            networkCall = { getResult { spotifyApi.getAlbumInfo(id) } },
            saveCallResult = {
                val albumWithTracksAndArtists = responseConverter.convertAlbumToEntity(it)
                database.getAlbumDao().insertAlbum(albumWithTracksAndArtists.albumInfo)
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
            networkCall = { getResult { spotifyApi.searchArtist(keyword) } },
            saveCallResult = {
                val artists = it.artists.items.map(responseConverter::convertArtistToEntity)
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
            networkCall = { getResult { spotifyApi.searchAlbum(keyword) } },
            saveCallResult = { response ->
                val albumAndArtists = response.albums.items.map(responseConverter::convertAlbumToEntity)
                albumAndArtists.forEach {
                    database.getAlbumDao().insertAlbum(it.albumInfo)
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
            networkCall = { getResult { spotifyApi.searchTrack(keyword) } },
            saveCallResult = {
                val tracks = it.tracks.items.map(responseConverter::convertTrackToEntity)
                tracks.forEach(database.getTrackDao()::insertTrack)
            })
    }
}