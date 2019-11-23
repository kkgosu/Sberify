package com.example.sberify.data

import com.example.sberify.data.model.*
import com.example.sberify.domain.IConverter
import com.example.sberify.domain.model.*
import java.util.*

class DataConverter : IConverter<BaseDataModel, BaseModel> {
    override fun convertAlbums(from: List<AlbumData>?): List<Album> {
        val albumsList = arrayListOf<Album>()
        from?.forEach {
            albumsList.add(
                    Album(it.id,
                            it.artists[0],
                            it.name,
                            convertTracks(it.tracks),
                            it.images[0].url,
                            it.release_date))
        }
/*        if (from is AlbumsData.Items) {
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
                            from.release_date))*/
        return albumsList
    }

    override fun convertArtists(from: List<ArtistData>): List<Artist> {
        val artistsList = arrayListOf<Artist>()
        from.forEach { artistData ->
            var image: Image? = null
            artistData.images?.let {
                if (it.isNotEmpty()) {
                    image = convertImages(it[0])
                }
            }
            artistsList.add(Artist(artistData.id,
                    image,
                    artistData.name,
                    artistData.genres))
        }
        /*if (from is ArtistsData.Items) {
            from.items.forEach {
                artistsList.add(Artist(it.id,
                        convertImages(if (it.images?.size!! > 0) it.images[0] else null),
                        it.name,
                        it.genres))
            }
        } else if (from is ArtistData) {
            artistsList.add(
                    Artist(from.id,
                            convertImages(if (from.images?.size!! > 0) from.images[0] else null),
                            from.name,
                            from.genres))
        }*/
        return artistsList
    }

    override fun convertTracks(from: TracksData?): List<Track> {
        val tracksList = arrayListOf<Track>()
        from?.items?.forEach {
            tracksList.add(
                    Track(it.id, it.name, convertArtists(it.artists)))
        }
        return tracksList
    }

    override fun convertImages(from: ImageData?): Image? {
        from?.let {
            return Image(it.url, it.height, it.width)
        }
        return null
    }

}