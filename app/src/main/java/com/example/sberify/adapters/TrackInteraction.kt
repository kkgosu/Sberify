package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.domain.TrackDomainModel
import com.example.sberify.models.presentation.TrackModel

interface TrackInteraction {
    fun onTrackSelected(item: TrackModel, view: View)
}