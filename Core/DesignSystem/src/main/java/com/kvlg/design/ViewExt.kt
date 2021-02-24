package com.kvlg.design

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

inline fun View.onClick(crossinline action: () -> Unit) = setOnClickListener { action() }

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
            context.drawable(R.drawable.avd_heart_to_filled)
        } else {
            context.drawable(R.drawable.avd_filled_heart_break)
        }
    )
}

fun Context.drawable(@DrawableRes res: Int): Drawable? {
    return ContextCompat.getDrawable(this, res)
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