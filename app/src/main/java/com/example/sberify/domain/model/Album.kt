package com.example.sberify.domain.model

import com.example.sberify.data.model.AlbumsResponse

data class Album(val id: String,
        val artist: AlbumsResponse.Artist,
        val name: String,
        val imageUrl: String,
        val releaseDate: String)