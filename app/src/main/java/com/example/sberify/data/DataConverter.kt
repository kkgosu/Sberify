package com.example.sberify.data

import com.example.sberify.data.model.*
import com.example.sberify.domain.IConverter
import com.example.sberify.domain.model.Album
import com.example.sberify.domain.model.BaseModel
import com.example.sberify.domain.model.Track

class DataConverter : IConverter<BaseDataModel, BaseModel> {
    override fun convertAlbums(from: BaseDataModel): List<Album> {
        val albumsList = arrayListOf<Album>()
        if (from is AlbumsData.Items) {
            from.items?.forEach {
                albumsList.add(
                        Album(it.id,
                                it.artists[0],
                                it.name,
                                null,
                                it.images[0].url,
                                it.release_date))
            }
        } else if (from is AlbumData) {
            albumsList.add(
                    Album(from.id,
                            from.artists[0],
                            from.name,
                            convertTracks(from.tracks),
                            from.images[0].url,
                            from.release_date))
        }
        return albumsList
    }

    override fun convertArtists(from: BaseDataModel): List<BaseModel> {
        return emptyList()
    }

    override fun convertTracks(from: BaseDataModel?): List<Track> {
        val tracksList = arrayListOf<Track>()
        (from as? TracksData)?.items?.forEach {
            tracksList.add(Track(it.id, it.name))
        }
        return tracksList
    }

    override fun convertImages(from: BaseDataModel): List<BaseModel> {
        return emptyList()
    }

}