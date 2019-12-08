package com.example.sberify.presentation.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.models.domain.BaseModel
import java.text.Normalizer

fun String.normalize(): String = Normalizer.normalize(this, Normalizer.Form.NFD)

fun <T : BaseModel> createDiffCallback(): DiffUtil.ItemCallback<T> =
        object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem.baseId == newItem.baseId

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem == newItem
        }

inline fun <reified T : ViewDataBinding> inflateLayout(@LayoutRes id: Int, parent: ViewGroup?): T =
        DataBindingUtil.inflate(LayoutInflater.from(parent?.context), id, parent, false)

