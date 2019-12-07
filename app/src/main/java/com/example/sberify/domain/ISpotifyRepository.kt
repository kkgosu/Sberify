package com.example.sberify.domain

import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Token
import com.example.sberify.models.domain.Track

interface ISpotifyRepository {
    suspend fun getToken(callback: (Token) -> Unit)
    suspend fun getNewReleases(): List<Album>
    suspend fun getAlbumInfo(id: String): List<Album>
    suspend fun searchArtist(keyword: String): List<Artist>
    suspend fun searchAlbum(keyword: String): List<Album>
    suspend fun searchTrack(keyword: String): List<Track>
}