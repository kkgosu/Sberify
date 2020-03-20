package com.example.sberify.presentation.ui.search

import android.view.View
import androidx.core.view.ViewCompat
import com.example.sberify.databinding.ItemAlbumBinding
import com.example.sberify.databinding.ItemTrackLineBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Track
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


fun trackAdapterDelegate(itemClickListener: (Track, View) -> Unit) =
    adapterDelegateViewBinding<Track, BaseModel, ItemTrackLineBinding>({ layoutInflater, parent ->
        ItemTrackLineBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, item.id)
                track = item
                pos = adapterPosition + 1
                executePendingBindings()
            }
        }
    }

fun albumAdapterDelegate(itemClickListener: (Album, View) -> Unit) =
    adapterDelegateViewBinding<Album, BaseModel, ItemAlbumBinding>({ layoutInflater, parent ->
        ItemAlbumBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.cardView, item.id)
                album = item
                palette = itemAlbumPalette
                executePendingBindings()
            }
        }
    }