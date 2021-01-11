package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.presentation.ArtistModel

interface ArtistInteraction {
    fun onArtistSelected(item: ArtistModel, view: View)
}
