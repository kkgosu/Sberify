package com.example.sberify.adapters

import com.example.sberify.base.BaseAdapter

class SearchAdapter(
    private val trackInteraction: TrackInteraction?,
    private val albumInteraction: AlbumInteraction?
) : BaseAdapter() {

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