package com.example.sberify.presentation.ui.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target

@BindingAdapter("image")
fun ImageView.loadImage(image: String?) = ifNotDestroyed {
    Glide.with(this).load(image).override(Target.SIZE_ORIGINAL).centerCrop().into(this)
}

private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}