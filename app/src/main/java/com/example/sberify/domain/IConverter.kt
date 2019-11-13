package com.example.sberify.domain

import com.example.sberify.data.model.ArtistData
import com.example.sberify.data.model.BaseDataModel
import com.example.sberify.data.model.ImageData
import com.example.sberify.data.model.TracksData
import com.example.sberify.domain.model.*

interface IConverter<From : BaseDataModel, To : BaseModel> {
    fun convertAlbums(from: From): List<Album>
    fun convertArtists(from: List<ArtistData>): List<Artist>
    fun convertTracks(from: TracksData?): List<Track>
    fun convertImages(from: ImageData?): Image
}