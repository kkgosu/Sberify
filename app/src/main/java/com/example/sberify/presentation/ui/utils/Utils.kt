package com.example.sberify.presentation.ui.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.sberify.domain.model.BaseModel
import java.text.Normalizer

fun String.normalize(): String = Normalizer.normalize(this, Normalizer.Form.NFD)

fun <T : BaseModel> createCallback(): DiffUtil.ItemCallback<T> =
        object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem.baseId == newItem.baseId

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
                    oldItem == newItem
        }
