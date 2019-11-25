package com.example.sberify.domain.model

data class Album(val id: String,
        val artist: Artist,
        val name: String,
        val tracks: List<Track>? = null, 
        val imageUrl: String, 
        val releaseDate: String) : BaseModel(id)