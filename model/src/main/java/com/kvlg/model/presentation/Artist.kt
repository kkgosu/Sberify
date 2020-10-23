package com.kvlg.model.presentation

data class Artist(
    val id: String,
    val image: Image?,
    val name: String,
    val genres: List<String>?
) : BaseModel(id)
