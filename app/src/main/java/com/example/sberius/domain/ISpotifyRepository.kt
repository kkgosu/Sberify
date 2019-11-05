package com.example.sberius.domain

import com.example.sberius.domain.model.Token

interface ISpotifyRepository {
    suspend fun getToken(): Token
}