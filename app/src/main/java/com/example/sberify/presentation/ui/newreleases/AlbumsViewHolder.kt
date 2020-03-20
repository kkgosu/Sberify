package com.example.sberify.presentation.ui.newreleases

import android.view.View
import androidx.core.view.ViewCompat
import com.example.sberify.adapters.AlbumInteraction
import com.example.sberify.base.BaseViewHolder
import com.example.sberify.databinding.ItemAlbumBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.presentation.ui.utils.bindings

class AlbumsViewHolder(
    view: View,
    private val interaction: AlbumInteraction?
) : BaseViewHolder(view) {

    private lateinit var data: Album
    private val binding: ItemAlbumBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is Album) {
            this.data = data
            binding.apply {
                ViewCompat.setTransitionName(binding.cardView, data.id)
                album = data
                palette = itemAlbumPalette
                executePendingBindings()
            }
        }
    }

    override fun onClick(v: View?) {
        interaction?.onAlbumSelected(data, v!!)
    }

    override fun onLongClick(v: View?): Boolean = false
}