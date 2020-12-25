package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.domain.AlbumDomainModel

interface AlbumInteraction {
    fun onAlbumSelected(item: AlbumDomainModel, view: View)
}