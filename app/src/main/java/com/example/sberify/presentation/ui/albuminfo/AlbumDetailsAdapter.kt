package com.example.sberify.presentation.ui.albuminfo

import com.example.sberify.adapters.TrackInteraction
import com.example.sberify.adapters.trackListedAdapterDelegate
import com.example.sberify.base.BaseAdapter1

class AlbumDetailsAdapter(private val trackInteraction: TrackInteraction?) : BaseAdapter1() {

    init {
        delegatesManager.addDelegate(trackListedAdapterDelegate { track, view ->
            trackInteraction?.onTrackSelected(track, view)
        })
    }
}