package com.example.sberify.presentation.ui.search

import com.example.sberify.adapters.*
import com.example.sberify.base.BaseAdapter1

class SearchAdapter(
    private val trackInteraction: TrackInteraction?,
    private val albumInteraction: AlbumInteraction?
) : BaseAdapter1() {

    init {
        delegatesManager
            .addDelegate(albumAdapterDelegate { album, view ->
                albumInteraction?.onAlbumSelected(album, view)
            })
            .addDelegate(trackCardViewAdapterDelegate { track, view ->
                trackInteraction?.onTrackSelected(track, view)
            })
            .addDelegate(artistAdapterDelegate())
    }
}