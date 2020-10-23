package com.kvlg.model.presentation

import java.io.Serializable

data class Album(
    val id: String,
    val artist: Artist,
    val name: String,
    val tracks: List<Track>? = null,
    val imageUrl: String,
    val releaseDate: String,
    var isFavorite: Boolean = false
) : BaseModel(id), Serializable