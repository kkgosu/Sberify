package com.example.sberify.presentation.ui.utils

import android.graphics.drawable.AnimatedVectorDrawable
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.example.sberify.R
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

fun View.visible(value: Boolean) {
    visibility = if (value) View.VISIBLE else View.GONE
}

fun LottieAnimationView.hideAnimation() {
    visibility = View.GONE
    cancelAnimation()
}

fun LottieAnimationView.showAnimation() {
    visibility = View.VISIBLE
    playAnimation()
}

fun ImageButton.setFavoriteIcon(isFavorite: Boolean) {
    setImageDrawable(
        if (isFavorite) {
            (ContextCompat.getDrawable(
                context,
                R.drawable.avd_heart_to_filled
            ))
        } else {
            ContextCompat.getDrawable(
                context,
                R.drawable.avd_filled_heart_break
            )
        }
    )
}

fun ImageButton.startAnim() {
    (drawable as AnimatedVectorDrawable).start()
}

fun ImageView.loadImage(image: String?) =
    image?.let {
        Glide.with(this.context)
            .load(it)
            .transition(DrawableTransitionOptions.withCrossFade(375))
            .override(Target.SIZE_ORIGINAL)
            .centerCrop()
            .into(this)
    }


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

fun FloatingActionButton.bindAppBarLayoutWithFab(appBarLayout: AppBarLayout) {
    appBarLayout.addOnOffsetChangedListener(
        AppBarLayout.OnOffsetChangedListener { appBarLayout1, verticalOffset ->
            val verticalOffsetPercentage = abs(
                verticalOffset
            ).toFloat() / appBarLayout1.totalScrollRange.toFloat()
            if (verticalOffsetPercentage > 0.4 && isOrWillBeShown) {
                hide()
            } else if (verticalOffsetPercentage <= 0.4f && isOrWillBeHidden && tag != View.GONE) {
                show()
            }
        }
    )
}