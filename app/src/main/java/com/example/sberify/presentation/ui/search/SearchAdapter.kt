package com.example.sberify.presentation.ui.search

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.ItemAlbumBinding
import com.example.sberify.databinding.ItemSearchBinding
import com.example.sberify.databinding.ItemTrackBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.createDiffCallback
import com.example.sberify.presentation.ui.utils.inflateLayout

class SearchAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK_ARTIST = createDiffCallback<Artist>()
    private val differArtist = AsyncListDiffer(this, DIFF_CALLBACK_ARTIST)

    private val DIFF_CALLBACK_ALBUM = createDiffCallback<Album>()
    private val differAlbum = AsyncListDiffer(this, DIFF_CALLBACK_ALBUM)

    private val DIFF_CALLBACK_TRACK = createDiffCallback<Track>()
    private val differTrack = AsyncListDiffer(this, DIFF_CALLBACK_TRACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                ARTIST_VIEW -> {
                    val binding = inflateLayout<ItemSearchBinding>(R.layout.item_search, parent)
                    ViewHolderArtist(binding, interaction)
                }
                ALBUM_VIEW -> {
                    val binding = inflateLayout<ItemAlbumBinding>(R.layout.item_album, parent)
                    ViewHolderAlbum(binding, interaction)
                }
                TRACK_VIEW -> {
                    val binding = inflateLayout<ItemTrackBinding>(R.layout.item_track, parent)
                    ViewHolderTrack(binding, interaction)
                }
                else -> {
                    val binding = inflateLayout<ItemSearchBinding>(R.layout.item_search, parent)
                    ViewHolderArtist(binding, interaction)
                }
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderArtist -> {
                val artist = differArtist.currentList[position]
                holder.bind(artist)
            }
            is ViewHolderAlbum -> {
                val album = differAlbum.currentList[position]
                holder.bind(album)
            }
            is ViewHolderTrack -> {
                val track = differTrack.currentList[position]
                holder.bind(track)
            }
        }
    }

    override fun getItemCount(): Int =
            when (currentSearchType) {
                SearchType.ARTIST -> differArtist.currentList.size
                SearchType.ALBUM -> differAlbum.currentList.size
                SearchType.TRACK -> differTrack.currentList.size
            }

    override fun getItemViewType(position: Int): Int =
            when (currentSearchType) {
                SearchType.ARTIST -> ARTIST_VIEW
                SearchType.ALBUM -> ALBUM_VIEW
                SearchType.TRACK -> TRACK_VIEW
            }

    @JvmName("submitListArtist")
    fun submitList(list: List<Artist>) {
        differAlbum.submitList(emptyList())
        differTrack.submitList(emptyList())
        differArtist.submitList(list)
    }

    @JvmName("submitListTrack")
    fun submitList(list: List<Track>) {
        differArtist.submitList(emptyList())
        differAlbum.submitList(emptyList())
        differTrack.submitList(list)
    }

    @JvmName("submitListAlbum")
    fun submitList(list: List<Album>) {
        differArtist.submitList(emptyList())
        differTrack.submitList(emptyList())
        differAlbum.submitList(list)
    }

    class ViewHolderArtist
    constructor(private val binding: ItemSearchBinding,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Artist) = with(itemView) {
            binding.apply {
                artist = item
                executePendingBindings()
            }
            itemView.setOnClickListener {
                interaction?.onArtistSelected(adapterPosition, item, this)
            }
        }
    }

    class ViewHolderAlbum
    constructor(private val binding: ItemAlbumBinding,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Album) = with(itemView) {
            binding.apply {
                album = item
                palette = itemAlbumPalette
                executePendingBindings()
            }
            itemView.setOnClickListener {
                interaction?.onAlbumSelected(item, this)
            }
        }
    }


    class ViewHolderTrack
    constructor(private val binding: ItemTrackBinding,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Track) = with(itemView) {
            binding.apply {
                track = item
                executePendingBindings()
            }
            itemView.setOnClickListener {
                interaction?.onTrackSelected(adapterPosition, item, this)
            }
        }
    }

    interface Interaction {
        fun onArtistSelected(position: Int, item: Artist, view: View)
        fun onAlbumSelected(item: Album, view: View)
        fun onTrackSelected(position: Int, item: Track, view: View)
    }

    companion object {
        private const val ARTIST_VIEW = 0
        private const val ALBUM_VIEW = 1
        private const val TRACK_VIEW = 2

        var currentSearchType: SearchType = SearchType.ARTIST
    }
}
