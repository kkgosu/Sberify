package com.example.sberify.presentation.ui.newreleases

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.transition.TransitionInflater
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.data.Result
import com.example.sberify.databinding.FragmentNewReleasesBinding
import com.example.sberify.models.domain.Album
import com.example.sberify.models.domain.BaseModel
import com.example.sberify.presentation.ui.BaseFragment
import com.example.sberify.presentation.ui.Injectable


class NewReleasesFragment : BaseFragment(), Injectable {

    private lateinit var releasesAdapter: NewReleasesAdapter<Album>
    private lateinit var gridLayoutManager: StaggeredGridLayoutManager
    private lateinit var releasesRecycler: RecyclerView
    private lateinit var lottieAnim: LottieAnimationView
    private var mState: Parcelable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        initBinding<FragmentNewReleasesBinding>(R.layout.fragment_new_releases, container)

        releasesAdapter = NewReleasesAdapter(this)
        gridLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        releasesRecycler = mView.findViewById(R.id.new_releases_recycler)
        releasesRecycler.apply {
            layoutManager = gridLayoutManager
            adapter = releasesAdapter
            gridLayoutManager.onRestoreInstanceState(mState)
        }

        lottieAnim = mView.findViewById(R.id.loading_animation)

        sharedViewModel.newReleases.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Result.Status.SUCCESS -> {
                    it.data?.let { album ->
                        releasesAdapter.submitList(album)
                    }
                    lottieAnim.visibility = View.GONE
                    lottieAnim.cancelAnimation()
                }
                Result.Status.LOADING -> {
                    lottieAnim.visibility = View.VISIBLE
                    lottieAnim.playAnimation()
                }
                Result.Status.ERROR -> {
                    lottieAnim.visibility = View.VISIBLE
                    lottieAnim.playAnimation()
                }
            }
        })
        return mView
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
        sharedElementReturnTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        postponeEnterTransition()
        releasesRecycler.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    override fun onItemSelected(position: Int, item: BaseModel, view: View) {
        if (item is Album) {
            sharedViewModel.getAlbumInfo(item)
            val extras = FragmentNavigatorExtras(
                    view.findViewById<TextView>(R.id.release_name) to "${item.name}album",
                    view.findViewById<ImageView>(R.id.release_cover) to "${item.imageUrl}album",
                    view.findViewById<TextView>(R.id.artist_name) to "${item.artist.name}album")

            findNavController().navigate(R.id.action_newReleasesFragment_to_albumInfoFragment, null,
                    null, extras)
        }
    }
}