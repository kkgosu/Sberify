package com.kvlg.shared.data

import com.kvlg.model.presentation.Album
import com.kvlg.network.spotify.DataConverter
import com.kvlg.network.spotify.SpotifyApi
import com.kvlg.shared.data.db.AppDatabase
import com.kvlg.shared.data.db.album.AlbumEntity
import com.kvlg.shared.data.db.artists.ArtistEntity

/**
 * @author Konstantin Koval
 * @since 29.10.2020
 */
interface AlbumRepository {
    suspend fun getAlbumsFromSpotify(keyword: String): List<Album>?
    suspend fun getAlbumInfoFromSpotify(id: String): List<Album>
    suspend fun getNewReleases(): List<Album>
    fun getAlbumsFromDb(keyword: String): List<Album>
    fun saveAlbumIntoDb(album: Album)
    fun getAlbumInfoFromDb(id: String): Album
    fun updateAlbumInfoInDb(album: Album)
    fun getAllAlbumsFromDb(): List<Album>
}

class AlbumsRepositoryImpl(
    private val database: AppDatabase,
    private val spotifyApi: SpotifyApi,
    private val converter: DataConverter
) : AlbumRepository {

    override suspend fun getAlbumsFromSpotify(keyword: String): List<Album>? {
        return getResponse { spotifyApi.searchAlbum(keyword) }.albums.items?.let {
            converter.convertAlbums(it)
        }
    }

    override suspend fun getAlbumInfoFromSpotify(id: String): List<Album> {
        return getResponse { spotifyApi.getAlbumInfo(id) }.let { converter.convertAlbums(listOf(it)) }
    }

    override suspend fun getNewReleases(): List<Album> {
        return getResponse { spotifyApi.getNewReleases() }.albums.items.let { converter.convertAlbums(it) }
    }

    override fun getAlbumsFromDb(keyword: String): List<Album> {
        return database.getAlbumDao().getAlbumsByKeyword(keyword).map {
            it.toAlbum()
        }
    }

    override fun saveAlbumIntoDb(album: Album) {
        database.getAlbumDao().insertAlbum(album.toEntity())
    }

    override fun getAlbumInfoFromDb(id: String): Album {
        return database.getAlbumDao().getAlbumById(id).toAlbum()
    }

    override fun updateAlbumInfoInDb(album: Album) {
        database.getAlbumDao().updateAlbum(album.toEntity())
    }

    override fun getAllAlbumsFromDb(): List<Album> {
        return database.getAlbumDao().getAlbums().map {
            it.toAlbum()
        }
    }

    private fun AlbumEntity.toAlbum() =
        Album(
            id = spotifyId,
            artist = artist.toArtist(),
            name = name,
            tracks = trackIds,
            imageUrl = imageUrl,
            releaseDate = releaseDate,
            isFavorite = isFavorite
        )

    private fun Album.toEntity() =
        AlbumEntity(
            spotifyId = id,
            artistId = artist.id,
            artist = ArtistEntity.from(artist),
            name = name,
            trackIds = tracks,
            imageUrl = imageUrl,
            releaseDate = releaseDate,
            isFavorite = isFavorite
        )

}