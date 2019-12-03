package com.example.sberify.presentation.ui.newreleases

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.transition.TransitionInflater
import com.airbnb.lottie.LottieAnimationView
import com.example.sberify.R
import com.example.sberify.domain.model.Album
import com.example.sberify.presentation.ui.SharedViewModel
import dagger.android.support.AndroidSupportInjection


class NewReleasesFragment : Fragment(
        R.layout.fragment_new_releases), NewReleasesAdapter.Interaction {

    private lateinit var mViewModel: SharedViewModel
    private lateinit var mAdapter: NewReleasesAdapter
    private lateinit var mLayoutManager: StaggeredGridLayoutManager
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var lottieAnim: LottieAnimationView
    private var mState: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity()).get(
                SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)!!
        mAdapter = NewReleasesAdapter(this)
        mLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        mRecyclerView = view.findViewById(R.id.new_releases_recycler)
        mRecyclerView.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
            mLayoutManager.onRestoreInstanceState(mState)
        }

        lottieAnim = view.findViewById(R.id.loading_animation)

        mViewModel.newReleases.observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)
        })

        mViewModel.startLoadingAnim.observe(viewLifecycleOwner, Observer {
            lottieAnim.visibility = View.VISIBLE
            lottieAnim.playAnimation()
        })

        mViewModel.cancelLoadingAnim.observe(viewLifecycleOwner, Observer {
            lottieAnim.visibility = View.GONE
            lottieAnim.cancelAnimation()
        })
        return view
    }

    override fun onPause() {
        super.onPause()
        mState = mLayoutManager.onSaveInstanceState()
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
        mRecyclerView.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    override fun onItemSelected(item: Album, view: View) {
        mViewModel.getAlbumInfo(item)
        val extras = FragmentNavigatorExtras(
                view.findViewById<TextView>(R.id.release_name) to item.name,
                view.findViewById<ImageView>(R.id.release_cover) to item.id,
                view.findViewById<TextView>(R.id.artist_name) to item.artist.name)

        findNavController().navigate(R.id.action_newReleasesFragment_to_albumInfoFragment, null,
                null, extras)
    }
}