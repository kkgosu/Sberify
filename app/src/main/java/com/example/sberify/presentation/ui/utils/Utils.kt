package com.example.sberify.presentation.ui.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.kvlg.model.common.Result
import com.kvlg.model.presentation.Artist

fun convertArtistsToString(artists: List<Artist>): String {
    val builder = StringBuilder()
    artists.forEach {
        builder.append(it.name)
            .append(", ")
    }
    return builder.dropLast(2).toString()
}

inline fun <T> LiveData<Result<T>>.applyResultObserver(
    owner: LifecycleOwner,
    crossinline success: (T) -> Unit,
    crossinline loading: () -> Unit,
    crossinline error: (message: String?) -> Unit
): Unit =
    observe(owner) {
        when (it.status) {
            Result.Status.SUCCESS -> it.data?.let { data -> success.invoke(data) }
            Result.Status.LOADING -> loading.invoke()
            Result.Status.ERROR -> error(it.message)
        }
    }
