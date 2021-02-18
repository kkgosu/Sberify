package com.kvlg.spotify_common.adapters

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