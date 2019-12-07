package com.example.sberify.domain

import com.example.sberify.models.data.*
import com.example.sberify.models.domain.*

interface IConverter<From : BaseDataModel, To : BaseModel> {
    fun convertAlbums(from: List<AlbumData>?): List<Album>
    fun convertArtists(from: List<ArtistData>): List<Artist>
    fun convertTracks(from: List<TrackData>?): List<Track>
    fun convertImages(from: ImageData?): Image?
}