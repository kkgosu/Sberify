package com.example.sberify.adapters

import com.example.sberify.base.BaseAdapter

class TrackListedAdapter(private val trackInteraction: TrackInteraction?) : BaseAdapter() {

    init {
        delegatesManager.addDelegate(trackListedAdapterDelegate { track, view ->
            trackInteraction?.onTrackSelected(track, view)
        })
    }
}