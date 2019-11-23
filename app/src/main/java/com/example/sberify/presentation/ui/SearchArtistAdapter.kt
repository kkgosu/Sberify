package com.example.sberify.presentation.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.R
import com.example.sberify.domain.model.Artist
import kotlinx.android.synthetic.main.item_search_artist.view.*

class SearchArtistAdapter(private val interaction: Interaction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Artist>() {

        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_search_artist,
                        parent, false), interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Artist>) {
        differ.submitList(list)
    }

    class ViewHolder
    constructor(
            itemView: View,
            private val interaction: Interaction?) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Artist) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            artist_name.text = item.name
            item.image?.let {
                artist_image.loadImage(it.url)
            }
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Artist)
    }
}
