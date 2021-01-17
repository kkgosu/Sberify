package com.example.sberify.adapters

import android.view.View
import com.kvlg.spotify_api.models.presentation.ArtistModel

interface ArtistInteraction {
    fun onArtistSelected(item: ArtistModel, view: View)
}
