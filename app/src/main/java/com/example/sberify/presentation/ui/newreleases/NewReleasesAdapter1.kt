package com.example.sberify.presentation.ui.newreleases

import android.view.View
import com.example.sberify.R
import com.example.sberify.base.BaseAdapter1
import com.example.sberify.base.BaseViewHolder
import com.example.sberify.base.SectionRow
import com.example.sberify.models.domain.Album

class NewReleasesAdapter1(private val interaction: Interaction? = null) : BaseAdapter1() {

    interface Interaction {
        fun onItemSelected(item: Album, view: View)
    }

    init {
        addSection(arrayListOf<Album>())
    }

    fun addAlbumList(albums: List<Album>) {
        sections().first().run {
            clear()
            addAll(albums)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow): Int = R.layout.item_album

    override fun viewHolder(layout: Int, view: View): BaseViewHolder =
        NewReleasesViewHolder(view, interaction)
}