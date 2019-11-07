package com.example.sberify.data

import com.example.sberify.data.model.AlbumsData
import com.example.sberify.domain.IConverter
import com.example.sberify.domain.model.Album

class AlbumConverter : IConverter<AlbumsData.Items, List<Album>> {
    
    override fun convert(from: AlbumsData.Items): List<Album> {
        val albumsList = arrayListOf<Album>()
        from.items?.forEach {
            albumsList.add(
                    Album(it.id, it.artists[0], it.name, it.images!![0].url, it.release_date))
        }
        return albumsList
    }


}