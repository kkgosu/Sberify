package com.example.sberify.presentation.ui.favorite

import com.example.sberify.adapters.*
import com.example.sberify.base.BaseAdapter1


class FavoriteAdapter(
    private val trackInteraction: TrackInteraction?,
    private val albumInteraction: AlbumInteraction?
) : BaseAdapter1() {

    init {
        delegatesManager
            .addDelegate(trackCardViewAdapterDelegate { track, view ->
                trackInteraction?.onTrackSelected(track, view)
            })
            .addDelegate(albumAdapterDelegate { album, view ->
                albumInteraction?.onAlbumSelected(album, view)
            })
            .addDelegate(headerAdapterDelegate())
    }
}