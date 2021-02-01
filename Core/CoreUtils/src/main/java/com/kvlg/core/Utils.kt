package com.kvlg.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

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