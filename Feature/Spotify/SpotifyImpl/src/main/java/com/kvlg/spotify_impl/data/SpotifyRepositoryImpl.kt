package com.kvlg.spotify_impl.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.kvlg.core.ResponseHandler.getResult
import com.kvlg.core.Result
import com.kvlg.core.database.AppDatabase
import com.kvlg.core.resultLiveData
import com.kvlg.core_db.database.DbConverter
import com.kvlg.spotify_impl.data.converters.ResponseConverter
import com.kvlg.spotify_impl.data.network.SpotifyApiMapper
import com.kvlg.spotify_models.domain.AlbumDomainModel
import com.kvlg.spotify_models.domain.ArtistDomainModel
import com.kvlg.spotify_models.domain.TrackDomainModel

/**
 * @author Konstantin Koval
 * @since 17.01.2021
 */
internal class SpotifyRepositoryImpl(
    private val database: AppDatabase,
    private val spotifyApi: SpotifyApiMapper,
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