package com.example.sberify.base

import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.models.domain.BaseModel
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter


open class BaseAdapter : AsyncListDifferDelegationAdapter<BaseModel>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<BaseModel> =
            object : DiffUtil.ItemCallback<BaseModel>() {
                override fun areItemsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean =
                    oldItem.baseId == newItem.baseId

                override fun areContentsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean =
                    oldItem == newItem
            }
    }
}