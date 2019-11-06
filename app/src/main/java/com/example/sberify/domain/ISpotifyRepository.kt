package com.example.sberify.domain

import com.example.sberify.data.model.AlbumsResponse
import com.example.sberify.domain.model.Token

interface ISpotifyRepository {
    suspend fun getToken(): Token
    suspend fun getNewReleases(): AlbumsResponse.Items
    suspend fun search(keyword: String): AlbumsResponse.Artist
}