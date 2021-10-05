package com.kvlg.spotify_common.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

/**
 * @author Konstantin Koval
 * @since 18.02.2021
 */

fun ImageView.bindPalette(path: String?, paletteView: View) {
    path?.let {
        Glide.with(this.context)
            .asBitmap()
            .load(path)
            .transition(BitmapTransitionOptions.withCrossFade(375))
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) = Unit
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    this@bindPalette.setImageBitmap(resource)
                    Palette.Builder(resource).generate { palette ->
                        palette?.dominantSwatch?.rgb?.let(paletteView::setBackgroundColor)
                    }
                }
            })
    }
}