package com.example.sberify.domain

import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token
import com.example.sberify.domain.model.Track

interface ISpotifyRepository {
    suspend fun getToken(): Token
    suspend fun getNewReleases(): List<Album>
    suspend fun getAlbumInfo(id: String): List<Album>
    suspend fun searchArtist(keyword: String): List<Artist>
    suspend fun searchAlbum(keyword: String): List<Album>
    suspend fun searchTrack(keyword: String): List<Track>
}