package com.example.sberify.presentation.ui.utils

import android.app.Activity
import android.graphics.Color
import android.transition.TransitionManager
import android.view.View
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.newreleases.NewReleasesAdapter
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
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

@BindingAdapter("transformFab", "transformContainer")
fun bindTransformFab(view: View, fab: FloatingActionButton, container: CoordinatorLayout) {
    fab.setOnClickListener {
        fab.tag = View.GONE
        TransitionManager.beginDelayedTransition(container, getTransform(view, fab))
        fab.visibility = View.GONE
        view.visibility = View.VISIBLE
    }

    view.setOnClickListener {
        fab.tag = View.VISIBLE
        TransitionManager.beginDelayedTransition(container, getTransform(view, fab))
        fab.visibility = View.VISIBLE
        view.visibility = View.GONE

    }
}

fun Fragment.simpleToolbarWithHome(toolbar: MaterialToolbar, title_: String? = "") {
    (requireActivity() as AppCompatActivity).apply {
        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = title_
        }
    }
}

@BindingAdapter("simpleToolbarWithHome", "simpleToolbarTitle")
fun bindToolbarWithTitle(toolbar: MaterialToolbar, fragment: Fragment, title: String?) {
    fragment.simpleToolbarWithHome(toolbar, title)
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

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterAlbumList", "animation", "swipeRefreshLayout")
fun bindAdapterPosterList(
    view: RecyclerView,
    albums: Result<List<Album>>,
    anim: LottieAnimationView,
    swipeRefreshLayout: SwipeRefreshLayout
) {
    when (albums.status) {
        Result.Status.SUCCESS -> {
            swipeRefreshLayout.isRefreshing = false
            albums.data?.let { album ->
                (view.adapter as? NewReleasesAdapter<Album>)?.submitList(album)
            }
            hideAnimation(anim)
        }
        Result.Status.LOADING -> {
            showAnimation(anim)
        }
        Result.Status.ERROR -> {
            showAnimation(anim)
        }
    }
}

private fun hideAnimation(anim: LottieAnimationView) {
    anim.visibility = View.GONE
    anim.cancelAnimation()
}

private fun showAnimation(anim: LottieAnimationView) {
    anim.visibility = View.VISIBLE
    anim.playAnimation()
}

private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
    val drawable = ContextCompat.getDrawable(this.context, drawableRes)
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}