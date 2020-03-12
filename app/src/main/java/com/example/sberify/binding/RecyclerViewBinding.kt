package com.example.sberify.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.base.BaseAdapter1
import com.example.sberify.data.Result
import com.example.sberify.models.domain.Album
import com.example.sberify.presentation.ui.newreleases.NewReleasesAdapter1
import com.example.sberify.presentation.ui.utils.hideAnimation
import com.example.sberify.presentation.ui.utils.showAnimation

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter1) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterAlbumList", "animation", "swipeRefreshLayout")
fun bindAdapterPosterList(
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