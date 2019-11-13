package com.example.sberify.domain

import com.example.sberify.data.model.BaseDataModel
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.BaseModel
import com.example.sberify.domain.model.Track

interface IConverter<From : BaseDataModel, To : BaseModel> {
    fun convertAlbums(from: From): List<Album>
    fun convertArtists(from: From): List<To>
    fun convertTracks(from: From?): List<Track>
    fun convertImages(from: From): List<To>
}