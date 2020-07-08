package com.example.sberify.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.adapters.AlbumsAdapter
import com.example.sberify.adapters.TrackListedAdapter
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Album
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.utils.hideAnimation
import com.example.sberify.presentation.ui.utils.setFavoriteIcon
import com.example.sberify.presentation.ui.utils.showAnimation
import com.example.sberify.presentation.ui.utils.startAnim
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterTrackList", "fab", "viewModel")
fun bindAdapterAlbumDetails(
    recyclerView: RecyclerView,
    albumDetails: Result<Album>?,
    fab: FloatingActionButton,
    viewModel: SharedViewModel
) {
    albumDetails?.let {
        when (albumDetails.status) {
            Result.Status.SUCCESS -> {
                albumDetails.data?.let { album ->
                    album.tracks?.let { tracks ->
                        (recyclerView.adapter as? TrackListedAdapter)?.items = tracks
                        fab.apply {
                            setFavoriteIcon(!album.isFavorite)
                            setOnClickListener {
                                album.isFavorite = !album.isFavorite
                                viewModel.updateFavoriteAlbum(album)
                                setFavoriteIcon(album.isFavorite)
                                startAnim()
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

@BindingAdapter("adapterAlbumList", "animation", "swipeRefreshLayout")
fun bindAdapterAlbumList(
    recyclerView: RecyclerView,
    albums: Result<List<Album>>?,
    anim: LottieAnimationView,
    swipeRefreshLayout: SwipeRefreshLayout
) {
    albums?.let {
        when (albums.status) {
            Result.Status.SUCCESS -> {
                swipeRefreshLayout.isRefreshing = false
                albums.data?.let { album ->
                    (recyclerView.adapter as? AlbumsAdapter)?.items = album
                }
                anim.hideAnimation()
            }
            Result.Status.LOADING -> {
                anim.showAnimation()
            }
            Result.Status.ERROR -> {
                anim.showAnimation()
            }
        }
    }
}