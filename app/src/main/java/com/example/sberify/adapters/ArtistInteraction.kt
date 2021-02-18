package com.example.sberify.adapters

import android.view.View
import com.kvlg.spotify_common.presentation.ArtistModel

interface ArtistInteraction {
    fun onArtistSelected(item: ArtistModel, view: View)
}
