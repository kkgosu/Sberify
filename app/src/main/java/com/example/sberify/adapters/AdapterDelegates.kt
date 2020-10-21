package com.example.sberify.adapters

import android.view.View
import androidx.core.view.ViewCompat
import com.example.sberify.databinding.*
import com.example.sberify.models.domain.*
import com.example.sberify.presentation.ui.utils.bindPalette
import com.example.sberify.presentation.ui.utils.convertArtistsToString
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
                trackName.text = item.name
                artistName.text = convertArtistsToString(item.artists)
                position.text = (adapterPosition + 1).toString()
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
                name.text = item.name
                artistName.text = item.artists[0].name
                cover.bindPalette(item.image?.url, itemTrackPalette)
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
                releaseName.text = item.name
                artistName.text = item.artist.name
                releaseCover.bindPalette(item.imageUrl, itemAlbumPalette)
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
                releaseCover.bindPalette(item.imageUrl, itemAlbumPalette)
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
            binding.suggestionText.text = item.text
        }
    }

fun artistAdapterDelegate() =
    adapterDelegateViewBinding<Artist, BaseModel, ItemSearchBinding>({ layoutInflater, parent ->
        ItemSearchBinding.inflate(layoutInflater, parent, false)
    }) {
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, item.id)
                searchImage.bindPalette(item.image?.url, itemSearchPalette)
                searchName.text = item.name
            }
        }
    }