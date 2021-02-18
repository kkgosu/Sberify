package com.kvlg.spotify_common.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette

/**
 * @author Konstantin Koval
 * @since 18.02.2021
 */

fun ImageView.bindPalette(path: String?, palette: View) {
    path?.let {
        Glide.with(this.context)
            .load(path)
            .transition(DrawableTransitionOptions.withCrossFade(375))
            .listener(
                GlidePalette.with(path)
                    .use(BitmapPalette.Profile.VIBRANT_DARK)
                    .intoBackground(palette)
                    .crossfade(true)
            )
            .into(this)
    }
}