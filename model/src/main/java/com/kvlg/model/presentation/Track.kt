package com.kvlg.model.presentation

import java.io.Serializable

data class Track(
    val id: String,
    val name: String,
    val image: Image?,
    val artists: List<Artist>,
    var lyrics: String? = null,
    var isFavorite: Boolean = false
) : BaseModel(id), Serializable