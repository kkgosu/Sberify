package com.example.sberify.binding

import android.app.Activity
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.lyrics.LyricsViewModel
import com.example.sberify.presentation.ui.utils.hideAnimation
import com.example.sberify.presentation.ui.utils.setFavoriteIcon
import com.example.sberify.presentation.ui.utils.showAnimation
import com.example.sberify.presentation.ui.utils.startAnim
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

@BindingAdapter("image")
fun ImageView.loadImage(image: String?) = ifNotDestroyed {
    image?.let {
        Glide.with(this.context)
            .load(it)
            .transition(DrawableTransitionOptions.withCrossFade(375))
            .override(Target.SIZE_ORIGINAL)
            .centerCrop()
            .into(this)
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

@BindingAdapter("lyrics", "animation")
fun bindLyrics(
    textView: TextView,
    track: Result<Track>?,
    anim: LottieAnimationView
) {
    when (track?.status) {
        Result.Status.SUCCESS -> {
            track.data?.lyrics?.let {
                hideAnimation(anim)
                textView.visibility = View.VISIBLE
                textView.text = it
            }
        }
        Result.Status.LOADING -> {
            showAnimation(anim)
            textView.visibility = View.GONE
        }
        Result.Status.ERROR -> {
            hideAnimation(anim)
            textView.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("track", "viewModel")
fun bindFavoriteButton(
    favButton: ImageButton,
    track: Result<Track>?,
    viewModel: LyricsViewModel
) {
    when (track?.status) {
        Result.Status.SUCCESS -> {
            val data = track.data
            data?.lyrics?.let {
                favButton.apply {
                    setFavoriteIcon(this, !data.isFavorite)
                    setOnClickListener {
                        data.isFavorite = !data.isFavorite
                        viewModel.updateTrack(data)
                        setFavoriteIcon(this, data.isFavorite)
                        startAnim(this)
                    }
                }
            }
        }
        Result.Status.LOADING -> {
        }
        Result.Status.ERROR -> {
        }
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

private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}