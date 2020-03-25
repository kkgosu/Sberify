package com.example.sberify.presentation.ui.favorite

import com.example.sberify.adapters.AlbumInteraction
import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.adapters.albumAdapterDelegate
import com.example.sberify.adapters.trackAdapterDelegate
import com.example.sberify.base.BaseAdapter1


class FavoriteAdapter(
    private val trackInteraction: TrackInteraction?,
    private val albumInteraction: AlbumInteraction
) : BaseAdapter1() {

    init {
        delegatesManager
            .addDelegate(trackAdapterDelegate { track, view ->
                trackInteraction?.onTrackSelected(track, view)
            })
            .addDelegate(albumAdapterDelegate { album, view ->
                albumInteraction.onAlbumSelected(album, view)
            })
    }
}