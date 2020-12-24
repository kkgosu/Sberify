package com.example.sberify.adapters

import android.view.View
import androidx.core.view.ViewCompat
import com.example.sberify.databinding.ItemAlbumBinding
import com.example.sberify.databinding.ItemAlbumHorizontalBinding
import com.example.sberify.databinding.ItemSearchBinding
import com.example.sberify.databinding.ItemSuggestionBinding
import com.example.sberify.databinding.ItemTrackBinding
import com.example.sberify.databinding.ItemTrackListedBinding
import com.example.sberify.models.domain.AlbumDomainModel
import com.example.sberify.models.domain.ArtistDomainModel
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.TrackDomainModel
import com.example.sberify.presentation.ui.utils.bindPalette
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


fun trackListedAdapterDelegate(itemClickListener: (TrackDomainModel, View) -> Unit) =
    adapterDelegateViewBinding<TrackDomainModel, BaseModel, ItemTrackListedBinding>({ layoutInflater, parent ->
        ItemTrackListedBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, item.id)
                trackName.text = item.name
                artistName.text = item.artistNames
                position.text = (adapterPosition + 1).toString()
            }
        }
    }

fun trackCardViewAdapterDelegate(itemClickListener: (TrackDomainModel, View) -> Unit) =
    adapterDelegateViewBinding<TrackDomainModel, BaseModel, ItemTrackBinding>({ layoutInflater, parent ->
        ItemTrackBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, item.id)
                name.text = item.name
                artistName.text = item.artistNames
                cover.bindPalette(null, itemTrackPalette)
            }
        }
    }

fun albumAdapterDelegate(itemClickListener: (AlbumDomainModel, View) -> Unit) =
    adapterDelegateViewBinding<AlbumDomainModel, BaseModel, ItemAlbumBinding>({ layoutInflater, parent ->
        ItemAlbumBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.cardView, item.id)
                releaseName.text = item.name
                artistName.text = item.artistNames
                releaseCover.bindPalette(item.images[0].url, itemAlbumPalette)
            }
        }
    }

fun albumHorizontalAdapterDelegate(itemClickListener: (AlbumDomainModel, View) -> Unit) =
    adapterDelegateViewBinding<AlbumDomainModel, BaseModel, ItemAlbumHorizontalBinding>({ layoutInflater, parent ->
        ItemAlbumHorizontalBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.cardView, item.id)
                releaseCover.bindPalette(item.images[0].url, itemAlbumPalette)
                releaseName.text = item.name
                artistName.text = item.artistNames
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
    adapterDelegateViewBinding<ArtistDomainModel, BaseModel, ItemSearchBinding>({ layoutInflater, parent ->
        ItemSearchBinding.inflate(layoutInflater, parent, false)
    }) {
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.itemContainer, item.id)
                searchImage.bindPalette(item.imageUrl, itemSearchPalette)
                searchName.text = item.name
            }
        }
    }