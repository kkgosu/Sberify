package com.example.sberify.presentation.ui.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.domain.model.BaseModel
import java.text.Normalizer

fun String.normalize(): String = Normalizer.normalize(this, Normalizer.Form.NFD)

fun <T : BaseModel> createDiffCallback(): DiffUtil.ItemCallback<T> =
        object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem.baseId == newItem.baseId

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem == newItem
        }

fun inflateLayout(@LayoutRes id: Int, parent: ViewGroup): View =
        LayoutInflater.from(parent.context).inflate(id, parent, false)
