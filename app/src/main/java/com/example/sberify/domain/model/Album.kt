package com.example.sberify.domain.model

import com.example.sberify.data.model.ArtistData

data class Album(val id: String,
        val artist: ArtistData,
        val name: String,
        val tracks: List<Track>? = null, 
        val imageUrl: String, 
        val releaseDate: String) : BaseModel()