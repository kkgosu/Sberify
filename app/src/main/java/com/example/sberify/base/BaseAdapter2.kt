package com.example.sberify.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter2 : RecyclerView.Adapter<BaseViewHolder>() {

    protected abstract fun layout(position: Int): Int
    protected abstract fun viewHolder(@LayoutRes layout: Int, view: View): BaseViewHolder

    override fun onCreateViewHolder(viewGroup: ViewGroup, @LayoutRes layout: Int): BaseViewHolder {
        val view = inflateView(viewGroup, layout)
        return viewHolder(layout, view)
    }

    override fun getItemViewType(position: Int): Int = layout(position)

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }

}