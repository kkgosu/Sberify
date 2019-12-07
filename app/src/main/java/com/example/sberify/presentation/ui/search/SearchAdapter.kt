package com.example.sberify.presentation.ui.search

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Artist
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.createDiffCallback
import com.example.sberify.presentation.ui.utils.inflateLayout
import com.example.sberify.presentation.ui.utils.loadImage
import kotlinx.android.synthetic.main.item_album.view.*
import kotlinx.android.synthetic.main.item_search.view.*

class SearchAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var currentSearchType: SearchType = SearchType.ARTIST

    private val DIFF_CALLBACK_ARTIST = createDiffCallback<Artist>()
    private val differArtist = AsyncListDiffer(this, DIFF_CALLBACK_ARTIST)

    private val DIFF_CALLBACK_ALBUM = createDiffCallback<Album>()
    private val differAlbum = AsyncListDiffer(this, DIFF_CALLBACK_ALBUM)

    private val DIFF_CALLBACK_TRACK = createDiffCallback<Track>()
    private val differTrack = AsyncListDiffer(this, DIFF_CALLBACK_TRACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                ARTIST_VIEW -> ViewHolderArtist(inflateLayout(R.layout.item_search, parent),
                        interaction)
                ALBUM_VIEW -> ViewHolderAlbum(inflateLayout(R.layout.item_album, parent),
                        interaction)
                TRACK_VIEW -> ViewHolderTrack(inflateLayout(R.layout.item_album, parent),
                        interaction)
                else -> ViewHolderArtist(inflateLayout(R.layout.item_search, parent), interaction)
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderArtist -> {
                holder.bind(differArtist.currentList[position])
            }
            is ViewHolderAlbum -> {
                holder.bind(differAlbum.currentList[position])
            }
            is ViewHolderTrack -> {
                holder.bind(differTrack.currentList[position])
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
    constructor(itemView: View,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Artist) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onArtistSelected(adapterPosition, item)
            }
            search_name.text = item.name
            item.image?.let {
                search_image.loadImage(it.url)
            }
        }
    }

    class ViewHolderAlbum
    constructor(itemView: View,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Album) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onAlbumSelected(item, this)
            }
            release_cover.loadImage(item.imageUrl)
            release_name.text = item.name
            artist_name.text = item.artist.name

            release_cover.transitionName = item.id
            release_name.transitionName = item.name
            artist_name.transitionName = item.artist.name
        }
    }


    class ViewHolderTrack
    constructor(itemView: View,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Track) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onTrackSelected(adapterPosition, item)
            }
            item.image?.let {
                release_cover.loadImage(it.url)
            }
            release_name.text = item.name
            artist_name.text = item.artists[0].name
        }
    }

    interface Interaction {
        fun onArtistSelected(position: Int, item: Artist)
        fun onAlbumSelected(item: Album, view: View)
        fun onTrackSelected(position: Int, item: Track)
    }

    companion object {
        private const val ARTIST_VIEW = 0
        private const val ALBUM_VIEW = 1
        private const val TRACK_VIEW = 2
    }
}
