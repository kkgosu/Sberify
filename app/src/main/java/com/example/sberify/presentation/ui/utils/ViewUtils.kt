package com.example.sberify.presentation.ui.utils

import android.graphics.drawable.AnimatedVectorDrawable
import android.view.View
import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R


fun hideAnimation(anim: LottieAnimationView) {
    anim.visibility = View.GONE
    anim.cancelAnimation()
}

fun showAnimation(anim: LottieAnimationView) {
    anim.visibility = View.VISIBLE
    anim.playAnimation()
}


fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
    val drawable = ContextCompat.getDrawable(this.context, drawableRes)
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}

fun setFavoriteIcon(imageButton: ImageButton, isFavorite: Boolean) {
    with(imageButton) {
        setImageDrawable(
            if (isFavorite) {
                (context.getDrawable(
                    R.drawable.avd_heart_to_filled
                ))
            } else {
                context.getDrawable(
                    R.drawable.avd_filled_heart_break
                )
            }
        )
    }
}

fun startAnim(imageButton: ImageButton) {
    with(imageButton) {
        (drawable as AnimatedVectorDrawable).start()
    }
}