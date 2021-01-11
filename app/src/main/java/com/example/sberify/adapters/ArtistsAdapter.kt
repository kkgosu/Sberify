package com.example.sberify.adapters

import com.example.sberify.base.BaseAdapter

/**
 * @author Konstantin Koval
 * @since 11.01.2021
 */
class ArtistsAdapter(private val artistInteraction: ArtistInteraction) : BaseAdapter() {

    init {
        delegatesManager.addDelegate(artistAdapterDelegate { artist, view ->
            artistInteraction.onArtistSelected(artist, view)
        })
    }
}