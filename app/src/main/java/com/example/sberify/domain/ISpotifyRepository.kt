package com.example.sberify.domain

import com.example.sberify.data.model.ArtistsData
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.Token

interface ISpotifyRepository {
    suspend fun getToken(): Token
    suspend fun getNewReleases():  List<Album>
    suspend fun search(keyword: String): ArtistsData.Items
}