package com.example.sberify.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.adapters.AlbumsAdapter
import com.example.sberify.adapters.TrackListedAdapter
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.Suggestion
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.search.SuggestionsAdapter
import com.example.sberify.presentation.ui.utils.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    view.adapter = baseAdapter
}

@BindingAdapter("bindSuggestions")
fun bindSuggestions(
    recyclerView: RecyclerView,
    suggestions: List<Suggestion>?
) {
    suggestions?.let { (recyclerView.adapter as? SuggestionsAdapter)?.submitList(it) }
}

@BindingAdapter("bindFavTracks")
fun bindFavTracks(
    recyclerView: RecyclerView,
    tracks: List<Track>?
) {
    recyclerView.setDivider(R.drawable.divider)
    tracks?.let {
        (recyclerView.adapter as? TrackListedAdapter)?.items = tracks
    }
}

@BindingAdapter("bindFavAlbums")
fun bindFavAlbums(
    recyclerView: RecyclerView,
    albums: List<Album>?
) {
    albums?.let {
        (recyclerView.adapter as? AlbumsAdapter)?.items = albums
    }
}

@BindingAdapter("adapterTrackList", "fab", "viewModel")
fun bindAdapterAlbumDetails(
    recyclerView: RecyclerView,
    albumDetails: Result<Album>?,
    fab: FloatingActionButton,
    viewModel: SharedViewModel
) {
    recyclerView.setDivider(R.drawable.divider)
    albumDetails?.let {
        when (albumDetails.status) {
            Result.Status.SUCCESS -> {
                albumDetails.data?.let { album ->
                    album.tracks?.let { tracks ->
                        (recyclerView.adapter as? TrackListedAdapter)?.items = tracks
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