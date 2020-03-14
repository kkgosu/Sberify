package com.example.sberify.binding

import android.app.Activity
import android.graphics.Color
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Track
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform
import kotlin.math.abs

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

@BindingAdapter("bindName")
fun bindTextViewWithName(view: TextView, track: Result<Track>?) {
    track?.let {
        when (it.status) {
            Result.Status.SUCCESS -> {
                it.data?.let { track ->
                    view.text = track.name
                }
            }
            Result.Status.LOADING -> {
            }
            Result.Status.ERROR -> {
            }
        }
    }
}

@BindingAdapter("bindLyrics")
fun bindTextViewWithLyrics(view: TextView, track: Result<Track>?) {
    track?.let {
        when (it.status) {
            Result.Status.SUCCESS -> {
                it.data?.let { track ->
                    view.text = track.lyrics
                }
            }
            Result.Status.LOADING -> {
            }
            Result.Status.ERROR -> {
            }
        }
    }
}

@BindingAdapter("paletteImage", "palette")
fun ImageView.bindingPalette(path: String?, palette: View) {
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

@BindingAdapter("bindFab")
fun bindAppBarLayoutWithFab(appBarLayout: AppBarLayout, fab: FloatingActionButton) {
    appBarLayout.addOnOffsetChangedListener(
        AppBarLayout.OnOffsetChangedListener { appBarLayout1, verticalOffset ->
            val verticalOffsetPercentage = abs(
                verticalOffset
            ).toFloat() / appBarLayout1.totalScrollRange.toFloat()
            if (verticalOffsetPercentage > 0.4 && fab.isOrWillBeShown) {
                fab.hide()
            } else if (verticalOffsetPercentage <= 0.4f && fab.isOrWillBeHidden && fab.tag != View.GONE) {
                fab.show()
            }
        }
    )
}

@BindingAdapter("transformItem", "transformContainer")
fun bindTransformItem(view: View, item: View?, container: CoordinatorLayout) {
    item?.let {

        item.setOnClickListener {
            item.tag = View.GONE
            TransitionManager.beginDelayedTransition(container, getTransform(item, view))
            item.visibility = View.GONE
            view.visibility = View.VISIBLE
        }

        view.setOnClickListener {
            item.tag = View.VISIBLE
            TransitionManager.beginDelayedTransition(container, getTransform(view, item))
            item.visibility = View.VISIBLE
            view.visibility = View.GONE
        }
    }
}

internal fun getTransform(mStartView: View, mEndView: View): MaterialContainerTransform {
    return MaterialContainerTransform(mStartView.context).apply {
        startView = mStartView
        endView = mEndView
        pathMotion = MaterialArcMotion()
        duration = 650
        scrimColor = Color.TRANSPARENT
    }
}

private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}