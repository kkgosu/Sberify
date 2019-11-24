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
                            convertTracks(it.tracks?.items),
                            it.images[0].url,
                            it.release_date))
        }
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
        return artistsList
    }

    override fun convertTracks(from: List<TrackData>?): List<Track> {
        val tracksList = arrayListOf<Track>()
        from?.forEach {
            tracksList.add(
                    Track(it.id, it.name, convertImages(it.album?.images?.get(0)),
                            convertArtists(it.artists)))
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