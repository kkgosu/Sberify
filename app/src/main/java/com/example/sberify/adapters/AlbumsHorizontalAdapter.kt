package com.example.sberify.adapters

import com.example.sberify.base.BaseAdapter

/**
 * @author Konstantin Koval
 * @since 04.07.2020
 */
class AlbumsHorizontalAdapter(private val albumInteraction: AlbumInteraction?) : BaseAdapter() {

    init {
        delegatesManager.addDelegate(albumHorizontalAdapterDelegate { album, view ->
            albumInteraction?.onAlbumSelected(album, view)
        })
    }
}