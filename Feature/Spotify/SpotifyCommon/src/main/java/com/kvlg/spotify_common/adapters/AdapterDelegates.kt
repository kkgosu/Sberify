package com.kvlg.spotify_common.adapters

import android.view.View
import androidx.core.view.ViewCompat
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.kvlg.spotify_common.BaseModel
import com.kvlg.spotify_common.databinding.ItemAlbumBinding
import com.kvlg.spotify_common.databinding.ItemAlbumHorizontalBinding
import com.kvlg.spotify_common.databinding.ItemSearchBinding
import com.kvlg.spotify_common.databinding.ItemTrackBinding
import com.kvlg.spotify_common.databinding.ItemTrackListedBinding
import com.kvlg.spotify_common.domain.ArtistDomainModel
import com.kvlg.spotify_common.presentation.AlbumModel
import com.kvlg.spotify_common.presentation.ArtistModel
import com.kvlg.spotify_common.presentation.TrackModel
import com.kvlg.spotify_common.utils.bindPalette

fun artistAdapterDelegate(itemClickListener: (ArtistModel, View) -> Unit) =
    adapterDelegateViewBinding<ArtistModel, BaseModel, ItemAlbumHorizontalBinding>({ layoutInflater, parent ->
        ItemAlbumHorizontalBinding.inflate(layoutInflater, parent, false)
    }) {
        binding.root.setOnClickListener {
            itemClickListener.invoke(item, it)
        }
        bind {
            binding.apply {
                ViewCompat.setTransitionName(binding.cardView, item.id)
                releaseName.text = item.name
                releaseCover.bindPalette(item.imageUrl, itemAlbumPalette)
            }
        }
    }

fun trackListedAdapterDelegate(itemClickListener: (TrackModel, View) -> Unit) =
    adapterDelegateViewBinding<TrackModel, BaseModel, ItemTrackListedBinding>({ layoutInflater, parent ->
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

fun trackCardViewAdapterDelegate(itemClickListener: (TrackModel, View) -> Unit) =
    adapterDelegateViewBinding<TrackModel, BaseModel, ItemTrackBinding>({ layoutInflater, parent ->
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

fun albumAdapterDelegate(itemClickListener: (AlbumModel, View) -> Unit) =
    adapterDelegateViewBinding<AlbumModel, BaseModel, ItemAlbumBinding>({ layoutInflater, parent ->
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
                releaseCover.bindPalette(item.imageUrl, itemAlbumPalette)
            }
        }
    }

fun albumHorizontalAdapterDelegate(itemClickListener: (AlbumModel, View) -> Unit) =
    adapterDelegateViewBinding<AlbumModel, BaseModel, ItemAlbumHorizontalBinding>({ layoutInflater, parent ->
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
                artistName.text = item.artistNames
            }
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