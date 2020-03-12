package com.example.sberify.binding

import android.graphics.drawable.AnimatedVectorDrawable
import android.widget.ImageButton
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.base.BaseAdapter1
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Album
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.albuminfo.AlbumDetailsAdapter
import com.example.sberify.presentation.ui.newreleases.NewReleasesAdapter1
import com.example.sberify.presentation.ui.utils.hideAnimation
import com.example.sberify.presentation.ui.utils.setDivider
import com.example.sberify.presentation.ui.utils.showAnimation
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter1) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterTrackList", "fab", "viewModel")
fun bindAdapterAlbumDetails(
    view: RecyclerView,
    albumDetails: Result<Album>?,
    fab: FloatingActionButton,
    viewModel: SharedViewModel
) {
    view.setDivider(R.drawable.divider)
    albumDetails?.let {
        when (albumDetails.status) {
            Result.Status.SUCCESS -> {
                albumDetails.data?.let { album ->
                    album.tracks?.let { tracks ->
                        (view.adapter as? AlbumDetailsAdapter)?.addTrackList(tracks)
                        fab.apply {
                            setFavoriteIcon(this, !album.isFavorite)
                            setOnClickListener {
                                album.isFavorite = !album.isFavorite
                                viewModel.updateFavoriteAlbum(album)
                                setFavoriteIcon(this, album.isFavorite)
                                startAnim(this)
                            }
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

@BindingAdapter("adapterAlbumList", "animation", "swipeRefreshLayout")
fun bindAdapterAlbumList(
    view: RecyclerView,
    albums: Result<List<Album>>?,
    anim: LottieAnimationView,
    swipeRefreshLayout: SwipeRefreshLayout
) {
    albums?.let {
        when (albums.status) {
            Result.Status.SUCCESS -> {
                swipeRefreshLayout.isRefreshing = false
                albums.data?.let { album ->
                    (view.adapter as? NewReleasesAdapter1)?.addAlbumList(album)
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
}