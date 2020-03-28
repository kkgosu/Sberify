package com.example.sberify.adapters

import android.view.View
import com.example.sberify.models.domain.Album

interface AlbumInteraction {
    fun onAlbumSelected(item: Album, view: View)
}