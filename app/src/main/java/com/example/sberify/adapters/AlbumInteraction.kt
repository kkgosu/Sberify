package com.example.sberify.adapters

import android.view.View
import com.kvlg.model.presentation.Album

interface AlbumInteraction {
    fun onAlbumSelected(item: Album, view: View)
}