package com.example.sberify.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.sberify.data.DataConverter
import com.example.sberify.data.DbConverter
import com.example.sberify.data.ResponseConverter
import com.example.sberify.data.Result
import com.example.sberify.data.api.ISpotifyApi
import com.example.sberify.data.api.SearchTypes
import com.example.sberify.data.db.AppDatabase
import com.example.sberify.data.db.album.AlbumEntity
import com.example.sberify.data.db.artists.ArtistEntity
import com.example.sberify.data.db.track.TrackEntity
import com.example.sberify.data.resultLiveData
import com.example.sberify.domain.ISpotifyRepository
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Track
import com.example.sberify.models.newdomain.AlbumDomainModel
import com.example.sberify.presentation.ui.utils.ResponseHandler.getResult
import javax.inject.Inject

class SpotifyRepository @Inject constructor(
    private val dataConverter: DataConverter,
    private val database: AppDatabase,
    private val mSpotifyApi: ISpotifyApi,
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
            networkCall = { getResult { mSpotifyApi.getNewReleases() } },
            saveCallResult = { response ->
                val albumAndArtists = response.items.map(responseConverter::convertAlbumToEntity)
                albumAndArtists.forEach {
                    database.getAlbumDao().insertAlbum(it.first)
                    it.second.forEach { artist ->
                        database.getArtistDao().insertArtist(artist)
                    }
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
            networkCall = { getResult { mSpotifyApi.getAlbumInfo(id) } },
            saveCallResult = {
                val albumWithTracksAndArtists = responseConverter.convertAlbumToEntity(it)
                database.getAlbumDao().insertAlbum(albumWithTracksAndArtists.albumInfo)
                albumWithTracksAndArtists.artists.forEach { artistEntity ->
                    database.getArtistDao().insertArtist(artistEntity)
                }
                albumWithTracksAndArtists.tracks.forEach {tracksEntity ->
                    database.getTrackDao().insertTrack(tracksEntity)
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
                database.getTrackDao().getTracksByQuery(keyword).map {
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