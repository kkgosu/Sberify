package com.example.sberify.domain

import com.example.sberify.data.model.*
import com.example.sberify.domain.model.*

interface IConverter<From : BaseDataModel, To : BaseModel> {
    fun convertAlbums(from: From): List<Album>
    fun convertArtists(from: ArtistsData.Items): List<Artist>
    fun convertTracks(from: TracksData?): List<Track>
    fun convertImages(from: ImageData?): Image
}