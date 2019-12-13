package com.example.sberify.presentation.ui.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.example.sberify.models.domain.Track
import com.google.android.material.appbar.CollapsingToolbarLayout

@BindingAdapter("image")
fun ImageView.loadImage(image: String?) = ifNotDestroyed {
    image?.let {
        Glide.with(this)
                .load(it)
                .transition(DrawableTransitionOptions.withCrossFade(375))
                .override(Target.SIZE_ORIGINAL)
                .centerCrop()
                .into(this)
    }
}

@BindingAdapter("titleAdapter")
fun CollapsingToolbarLayout.setTitle(track: Track?) {
    track?.let {
        title = track.name + " - " + track.artists.joinToString(", ") {
            it.name
        }
    }
}

private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}