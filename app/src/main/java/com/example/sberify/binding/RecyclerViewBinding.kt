package com.example.sberify.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.data.Result
import com.example.sberify.models.domain.*
import com.example.sberify.presentation.ui.SharedViewModel
import com.example.sberify.presentation.ui.albuminfo.AlbumDetailsAdapter
import com.example.sberify.presentation.ui.favorite.FavoriteAdapter
import com.example.sberify.presentation.ui.newreleases.AlbumsAdapter
import com.example.sberify.presentation.ui.search.SearchAdapter
import com.example.sberify.presentation.ui.search.SearchFragment.Companion.CURRENT_SEARCH_TYPE
import com.example.sberify.presentation.ui.search.SearchType
import com.example.sberify.presentation.ui.search.SuggestionsAdapter
import com.example.sberify.presentation.ui.utils.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    view.adapter = baseAdapter
}

@BindingAdapter("searchArtist", "searchTrack", "searchAlbum")
fun bindSearchArtist(
    recyclerView: RecyclerView,
    artist: Result<List<Artist>>?,
    track: Result<List<Track>>?,
    album: Result<List<Album>>?
) {
    when (artist?.status) {
        Result.Status.SUCCESS -> {
            if (CURRENT_SEARCH_TYPE == SearchType.ARTIST) {
                artist.data?.let {
                    (recyclerView.adapter as? SearchAdapter)?.items = (it)
                }
            }
        }
    }
    when (album?.status) {
        Result.Status.SUCCESS -> {
            if (CURRENT_SEARCH_TYPE == SearchType.ALBUM) {
                album.data?.let {
                    (recyclerView.adapter as? SearchAdapter)?.items = (it)
                }
            }
        }
    }
    when (track?.status) {
        Result.Status.SUCCESS -> {
            if (CURRENT_SEARCH_TYPE == SearchType.TRACK) {
                track.data?.let {
                    (recyclerView.adapter as? SearchAdapter)?.items = (it)
                }
            }
        }
    }
}

@BindingAdapter("bindSuggestions")
fun bindSuggestions(
    recyclerView: RecyclerView,
    suggestions: List<Suggestion>?
) {
    suggestions?.let { (recyclerView.adapter as? SuggestionsAdapter)?.submitList(it) }
}

@BindingAdapter("bindFavTracks", "bindFavAlbums")
fun bindFavTracks(
    recyclerView: RecyclerView,
    tracks: List<Track>?,
    albums: List<Album>?
) {
    tracks?.let {
        albums?.let {
            (recyclerView.adapter as? FavoriteAdapter)?.items =
                listOf(Header("Favorite tracks")) +
                        tracks +
                        listOf(Header("Favorite albums")) +
                        albums
        }
    }
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
                        (view.adapter as? AlbumDetailsAdapter)?.items = tracks
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
                    (view.adapter as? AlbumsAdapter)?.submitList(album)
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