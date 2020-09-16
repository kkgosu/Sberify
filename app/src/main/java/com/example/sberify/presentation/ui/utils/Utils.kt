package com.example.sberify.presentation.ui.utils

import android.view.View
import androidx.databinding.BindingConversion
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Artist
import java.text.Normalizer

fun String.normalize(): String = Normalizer.normalize(this, Normalizer.Form.NFD)

inline fun <reified T : ViewDataBinding> bindings(view: View): Lazy<T> =
    lazy {
        requireNotNull(DataBindingUtil.bind<T>(view)) {
            "cannot find the matched view to layout."
        }
    }

@BindingConversion
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

fun View.visible(value: Boolean) {
    visibility = if (value) View.VISIBLE else View.GONE
}

