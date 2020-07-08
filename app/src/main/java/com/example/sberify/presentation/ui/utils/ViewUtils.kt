package com.example.sberify.presentation.ui.utils

import android.graphics.drawable.AnimatedVectorDrawable
import android.view.View
import android.widget.ImageButton
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R


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


fun ImageButton.startAnim() {
    (drawable as AnimatedVectorDrawable).start()
}