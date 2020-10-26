package com.kvlg.shared.data.spotify

import com.kvlg.model.presentation.Album
import com.kvlg.model.presentation.Artist
import com.kvlg.model.presentation.Track

/**
 * Repository for working with spotify's API
 *
 * @author Konstantin Koval
 * @since 26.10.2020
 */
interface SpotifyRepository {
    //region Track
    fun getTracksFromDb(keyword: String): List<Track>
    fun getTracksFromSpotify(keyword: String): List<Track>
    fun saveTrackIntoDb(track: Track)

    //region Album
    fun getAlbumsFromDb(keyword: String): List<Album>
    fun getAlbumsFromSpotify(keyword: String): List<Album>
    fun saveAlbumIntoDb(track: Album)
    fun getAlbumInfoFromDb(id: String): Album
    fun getAlbumInfoFromSpotify(id: String): Album
    fun updateAlbumInfoInDb(album: Album)
    fun getAllAlbumsFromDb(): List<Album>
    fun getNewReleases() : List<Album>

    //region Artist
    fun saveArtistIntoDb(artist: Artist)
    fun getArtistFromDb(keyword: String): List<Artist>
    fun getArtistFromSpotify(keyword: String): List<Artist>
}