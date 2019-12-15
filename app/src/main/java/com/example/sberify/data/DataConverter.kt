package com.example.sberify.data

import com.example.sberify.OpenForTesting
import com.example.sberify.domain.IConverter
import com.example.sberify.models.data.*
import com.example.sberify.models.domain.*

@OpenForTesting
class DataConverter : IConverter<BaseDataModel, BaseModel> {
    override fun convertAlbums(from: List<AlbumData>?): List<Album> {
        return from?.map {
            Album(it.id,
                    convertArtists(it.artists)[0],
                    it.name,
                    convertTracks(it.tracks?.items, it.images[0].url),
                    it.images[0].url,
                    it.release_date)
        } ?: emptyList()
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

    override fun convertTracks(from: List<TrackData>?, image: String): List<Track>? {
        return from?.map {
            Track(it.id, it.name,
                    convertImages(it.album?.images?.get(0)) ?: Image(image, 0, 0),
                    convertArtists(it.artists))
        }
    }

    override fun convertImages(from: ImageData?): Image? {
        from?.let {
            return Image(it.url, it.height, it.width)
        }
        return null
    }

}