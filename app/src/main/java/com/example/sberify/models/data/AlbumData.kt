package com.example.sberify.models.data

data class AlbumData(val id: String,
        val artists: List<ArtistData>,
        val images: List<ImageData>,
        val name: String,
        val tracks: TracksData.Items?,
        val popularity: Int? = null,
        val release_date: String) : BaseDataModel()