package com.example.sberify.domain

import com.example.sberify.data.model.*
import com.example.sberify.domain.model.*

interface IConverter<From : BaseDataModel, To : BaseModel> {
    fun convertAlbums(from: List<AlbumData>?): List<Album>
    fun convertArtists(from: List<ArtistData>): List<Artist>
    fun convertTracks(from: List<TrackData>?): List<Track>
    fun convertImages(from: ImageData?): Image?
}