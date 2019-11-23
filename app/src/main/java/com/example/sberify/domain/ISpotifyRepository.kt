package com.example.sberify.domain

import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Artist
import com.example.sberify.domain.model.Token

interface ISpotifyRepository {
    suspend fun getToken(): Token
    suspend fun getNewReleases(): List<Album>
    suspend fun getAlbumInfo(id: String): List<Album>
    suspend fun searchArtist(keyword: String): List<Artist>
}