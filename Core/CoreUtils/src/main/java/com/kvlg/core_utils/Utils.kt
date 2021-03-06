package com.kvlg.core_utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.kvlg.core_utils.Result

inline fun <T> LiveData<Result<T>>.applyResultObserver(
    owner: LifecycleOwner,
    crossinline success: (T) -> Unit,
    crossinline loading: () -> Unit,
    crossinline error: (message: String?) -> Unit
): Unit =
    observe(owner) {
        when (it.status) {
            Result.Status.SUCCESS -> it.data?.let { data -> success(data) }
            Result.Status.LOADING -> loading()
            Result.Status.ERROR -> error(it.message)
        }
    }
