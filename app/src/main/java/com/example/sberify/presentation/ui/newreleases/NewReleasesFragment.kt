package com.example.sberify.presentation.ui.newreleases

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.base.BaseFragment
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentNewReleasesBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.Injectable


class NewReleasesFragment : BaseFragment(), Injectable {

    private lateinit var releasesAdapter: NewReleasesAdapter<Album>
    private lateinit var gridLayoutManager: StaggeredGridLayoutManager
    private lateinit var releasesRecycler: RecyclerView
    private lateinit var lottieAnim: LottieAnimationView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private var mState: Parcelable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentNewReleasesBinding>(
            inflater,
            R.layout.fragment_new_releases,
            container
        ).apply {
            viewModel = sharedViewModel
            anim = loadingAnimation
            adapter = NewReleasesAdapter1()
            swipeRefresh = refreshLayout
        }.root



        initBinding<FragmentNewReleasesBinding>(R.layout.fragment_new_releases, container)
        releasesAdapter = NewReleasesAdapter(this)
        gridLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        releasesRecycler = mView.findViewById(R.id.new_releases_recycler)
        releasesRecycler.apply {
            layoutManager = gridLayoutManager
            adapter = releasesAdapter
            gridLayoutManager.onRestoreInstanceState(mState)
        }

        swipeRefreshLayout = mView.findViewById(R.id.refresh_layout)
        swipeRefreshLayout.setOnRefreshListener {
            sharedViewModel.refresh()
        }
        lottieAnim = mView.findViewById(R.id.loading_animation)
        sharedViewModel.newReleases.observe(viewLifecycleOwner) {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    swipeRefreshLayout.isRefreshing = false
                    it.data?.let { album ->
                        releasesAdapter.submitList(album)
                    }
                    lottieAnim.visibility = View.GONE
                    lottieAnim.cancelAnimation()
                }
                Result.Status.LOADING -> {
                    showAnimation()
                }
                Result.Status.ERROR -> {
                    showAnimation()
                }
            }
        }
        sharedViewModel.refresh()
        return mView
    }

    private fun showAnimation() {
        lottieAnim.visibility = View.VISIBLE
        lottieAnim.playAnimation()
    }

    override fun onPause() {
        super.onPause()
        mState = gridLayoutManager.onSaveInstanceState()
    }

    override fun onDestroy() {
        super.onDestroy()
        lottieAnim.cancelAnimation()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAnimations()
        releasesRecycler.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
        if (item is Album) {
            sharedViewModel.getAlbumInfo(item)
            val albumName = view.findViewById<TextView>(R.id.release_name)
            val albumCover = view.findViewById<ImageView>(R.id.release_cover)
            val artistName = view.findViewById<TextView>(R.id.artist_name)
            val extras = FragmentNavigatorExtras(
                albumName to albumName.transitionName,
                albumCover to albumCover.transitionName,
                artistName to artistName.transitionName
            )

            findNavController().navigate(
                R.id.action_newReleasesFragment_to_albumInfoFragment, null,
                null, extras
            )
        }
    }
}