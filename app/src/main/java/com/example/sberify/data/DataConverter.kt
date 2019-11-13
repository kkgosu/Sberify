package com.example.sberify.data

import com.example.sberify.data.model.*
import com.example.sberify.domain.IConverter
import com.example.sberify.domain.model.*

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

    override fun convertArtists(from: List<ArtistData>): List<Artist> {
        val artistsList = arrayListOf<Artist>()
        from.forEach {
            artistsList.add(Artist(it.id, convertImages(it.images?.get(0)), it.name, it.genres))
        }
        return emptyList()
    }

    override fun convertTracks(from: BaseDataModel?): List<Track> {
        val tracksList = arrayListOf<Track>()
        (from as? TracksData)?.items?.forEach {
            tracksList.add(Track(it.id, it.name, convertArtists(it.artists)))
        }
        return tracksList
    }

    override fun convertImages(from: BaseDataModel?): Image {
        if (from is ImageData) {
            return Image(from.height, from.width)
        }
        return Image(0, 0)
    }

}