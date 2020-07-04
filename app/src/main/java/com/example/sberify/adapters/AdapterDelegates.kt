package com.example.sberify.adapters

import android.view.View
import androidx.core.view.ViewCompat
import com.example.sberify.binding.bindingPalette
import com.example.sberify.databinding.*
import com.example.sberify.models.domain.*
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


fun trackListedAdapterDelegate(itemClickListener: (Track, View) -> Unit) =
    adapterDelegateViewBinding<Track, BaseModel, ItemTrackListedBinding>({ layoutInflater, parent ->
        ItemTrackListedBinding.inflate(layoutInflater, parent, false)
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

fun trackCardViewAdapterDelegate(itemClickListener: (Track, View) -> Unit) =
    adapterDelegateViewBinding<Track, BaseModel, ItemTrackBinding>({ layoutInflater, parent ->
        ItemTrackBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, item.id)
                track = item
                palette = itemTrackPalette
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

fun albumHorizontalAdapterDelegate(itemClickListener: (Album, View) -> Unit) =
    adapterDelegateViewBinding<Album, BaseModel, ItemAlbumHorizontalBinding>({ layoutInflater, parent ->
        ItemAlbumHorizontalBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.cardView, item.id)
                releaseCover.bindingPalette(item.imageUrl, itemAlbumPalette)
                releaseName.text = item.name
                artistName.text = item.artist.name
            }
        }
    }

fun suggestionAdapterDelegate(itemClickListener: (Int, Suggestion) -> Unit) =
    adapterDelegateViewBinding<Suggestion, Suggestion, ItemSuggestionBinding>({ layoutInflater, parent ->
        ItemSuggestionBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(adapterPosition, item)
        }
        bind {
            binding.apply {
                suggestionText.text = item.text
            }
        }
    }

fun artistAdapterDelegate() =
    adapterDelegateViewBinding<Artist, BaseModel, ItemSearchBinding>({ layoutInflater, parent ->
        ItemSearchBinding.inflate(layoutInflater, parent, false)
    }) {
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, item.id)
                artist = item
                palette = itemSearchPalette
                executePendingBindings()
            }
        }
    }