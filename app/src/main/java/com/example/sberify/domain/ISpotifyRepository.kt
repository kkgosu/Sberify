package com.example.sberify.domain

import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track

interface ISpotifyRepository {
    suspend fun getToken(callback: (Token) -> Unit)
    suspend fun getNewReleases(callback: (List<Album>) -> Unit)
    suspend fun getAlbumInfo(id: String, callback: (List<Album>) -> Unit)
    suspend fun searchArtist(keyword: String, callback: (List<Artist>) -> Unit)
    suspend fun searchAlbum(keyword: String, callback: (List<Album>) -> Unit)
    suspend fun searchTrack(keyword: String, callback: (List<Track>) -> Unit)
}