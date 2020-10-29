package com.kvlg.shared.data.spotify

import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Album

/**
 * Repository for working with spotify's API
 *
 * @author Konstantin Koval
 * @since 26.10.2020
 */
interface SpotifyRepository {
    //region Album
    suspend fun getAlbumsFromSpotify(keyword: String): Result<List<Album>>
    suspend fun getAlbumInfoFromSpotify(id: String): Result<Album>
    suspend fun getNewReleases(): Result<List<Album>>
    fun getAlbumsFromDb(keyword: String): List<Album>
    fun saveAlbumIntoDb(track: Album)
    fun getAlbumInfoFromDb(id: String): Album
    fun updateAlbumInfoInDb(album: Album)
    fun getAllAlbumsFromDb(): List<Album>
}