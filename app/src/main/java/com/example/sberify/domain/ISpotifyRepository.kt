package com.example.sberify.domain

import com.example.sberify.domain.model.Token

interface ISpotifyRepository {
    suspend fun getToken(): Token
}