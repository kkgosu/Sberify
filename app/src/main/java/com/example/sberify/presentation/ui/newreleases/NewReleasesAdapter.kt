package com.example.sberify.presentation.ui.newreleases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.databinding.ItemAlbumBinding
import com.example.sberify.domain.model.Album
import com.example.sberify.presentation.ui.utils.createDiffCallback

class NewReleasesAdapter(
        private val interaction: Interaction? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = createDiffCallback<Album>()
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val newReleasesBinding: ItemAlbumBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_album,
                        parent, false)
        return ViewHolder((newReleasesBinding), interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val album = differ.currentList[position]
                holder.bindingItem.album = album
                holder.bind(album)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Album>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(val bindingItem: ItemAlbumBinding, private val interaction: Interaction?) : RecyclerView.ViewHolder(
            bindingItem.root) {
        
        fun bind(item: Album) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(item, this)
            }
/*            release_cover.loadImage(item.imageUrl)
            release_name.text = item.name
            artist_name.text = item.artist.name

            release_cover.transitionName = item.id
            release_name.transitionName = item.name
            artist_name.transitionName = item.artist.name*/
        }
    }

    interface Interaction {
        fun onItemSelected(item: Album, view: View)
    }
}
