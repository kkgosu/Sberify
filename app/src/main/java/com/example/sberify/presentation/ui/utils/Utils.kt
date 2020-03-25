package com.example.sberify.presentation.ui.utils

import android.view.View
import androidx.databinding.BindingConversion
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
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

