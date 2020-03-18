package com.example.sberify.binding

import android.app.Activity
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.example.sberify.R
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.lyrics.LyricsViewModel
import com.example.sberify.presentation.ui.search.SearchType
import com.example.sberify.presentation.ui.search.SuggestionsAdapter
import com.example.sberify.presentation.ui.search.currentSearchType
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

@BindingAdapter("bindRadioGroup", "viewModel", "fragment")
fun RadioGroup.bindRadioGroup(
    group: RadioGroup,
    viewModel: SharedViewModel,
    fragment: Fragment
) {
    group.setOnCheckedChangeListener { _, checkedId ->
        when (checkedId) {
            R.id.artist_rb -> {
                viewModel.albums.removeObservers(fragment)
                viewModel.tracks.removeObservers(fragment)
                viewModel.artists.observe(fragment) {}
                currentSearchType = SearchType.ARTIST
            }
            R.id.album_rb -> {
                viewModel.artists.removeObservers(fragment)
                viewModel.tracks.removeObservers(fragment)
                viewModel.album.observe(fragment) {}
                currentSearchType = SearchType.ALBUM
            }
            R.id.track_rb -> {
                viewModel.artists.removeObservers(fragment)
                viewModel.albums.removeObservers(fragment)
                viewModel.tracks.observe(fragment) {}
                currentSearchType = SearchType.TRACK
            }
        }
    }
}

@BindingAdapter("suggestionRecycler", "suggestionAdapter", "viewModel")
fun bindSearchView(
    searchView: SearchView,
    suggestionsRecycler: RecyclerView,
    suggestionsAdapter: SuggestionsAdapter,
    viewModel: SharedViewModel
) {
    searchView.apply {
        setOnQueryTextFocusChangeListener { v, hasFocus ->
            suggestionsRecycler.visibility = if (hasFocus) {
                viewModel.getAllSuggestions()
                suggestionsRecycler.scheduleLayoutAnimation()
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { query ->
                    suggestionsAdapter.submitList(
                        suggestionsAdapter.getList().filter { it.text.contains(query, true) })
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.insertSuggestion(query!!)
                viewModel.search(query, currentSearchType)
                clearFocus()
                suggestionsRecycler.visibility = View.GONE
                return true
            }
        })
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