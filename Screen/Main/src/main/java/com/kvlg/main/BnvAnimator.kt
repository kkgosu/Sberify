package com.kvlg.main

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.core.view.updateLayoutParams
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @author Konstantin Koval
 * @since 18.02.2021
 */
class BnvAnimator(
    private val bnv: BottomNavigationView
) {
    private val bnvHeight: Int = bnv.context.resources.getDimensionPixelSize(com.kvlg.design.R.dimen.bottom_bar_height)
    private var heightAnimator: ValueAnimator = ObjectAnimator()
    private var state: BnvState = BnvState.VISIBLE

    fun animateBar(destinationId: Int) {
        if (destinationId == R.id.newReleasesFragment
            || destinationId == R.id.favoriteFragment
            || destinationId == R.id.searchFragment
        ) {
            if (state == BnvState.INVISIBLE) {
                show()
            }
        } else if (state == BnvState.VISIBLE) {
            hide()
        }
    }

    private fun hide() {
        createAnimator(bnvHeight, 0)
        state = BnvState.INVISIBLE
    }

    private fun show() {
        createAnimator(0, bnvHeight)
        state = BnvState.VISIBLE
    }

    private fun createAnimator(from: Int, to: Int) {
        heightAnimator.cancel()
        heightAnimator = ObjectAnimator.ofInt(from, to).apply {
            interpolator = FastOutSlowInInterpolator()
            duration = 800
            addUpdateListener {
                bnv.updateLayoutParams {
                    height = it.animatedValue as Int
                }
            }
            start()
        }
    }

    private enum class BnvState {
        VISIBLE, INVISIBLE
    }
}