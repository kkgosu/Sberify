package com.example.sberify.presentation.ui.albuminfo

import android.view.View
import com.example.sberify.R
import com.example.sberify.base.BaseAdapter1
import com.example.sberify.base.BaseViewHolder
import com.example.sberify.base.SectionRow
import com.example.sberify.models.domain.Track

class AlbumDetailsAdapter(private val interaction: Interaction? = null) : BaseAdapter1() {

    interface Interaction {
        fun onItemSelected(item: Track, view: View)
    }

    init {
        println("AlbumDetailsAdapter.init")
        addSection(arrayListOf<Track>())
    }

    fun addTrackList(tracks: List<Track>) {
        sections().first().run {
            clear()
            addAll(tracks)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow): Int = R.layout.item_track_listed

    override fun viewHolder(layout: Int, view: View): BaseViewHolder =
        AlbumDetailsViewHolder(view, interaction)

}