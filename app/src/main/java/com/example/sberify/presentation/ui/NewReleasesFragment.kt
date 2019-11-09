package com.example.sberify.presentation.ui

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.sberify.R
import com.example.sberify.domain.model.Album
import kotlinx.android.synthetic.main.bottom_app_bar.*

class NewReleasesFragment : Fragment(
        R.layout.fragment_new_releases), NewReleasesAdapter.Interaction {

    private lateinit var mViewModel: SharedViewModel
    private lateinit var mAdapter: NewReleasesAdapter
    private lateinit var mLayoutManager: StaggeredGridLayoutManager
    private lateinit var mRecyclerView: RecyclerView
    private var mState: Parcelable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        mRecyclerView = super.onCreateView(inflater, container, savedInstanceState) as RecyclerView
        mAdapter = NewReleasesAdapter(this)
        mLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mRecyclerView.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
            mLayoutManager.onRestoreInstanceState(mState)
        }

        mViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        mViewModel.newReleases.observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)
        })
        return mRecyclerView
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).apply {
            fab.setImageDrawable(getDrawable(R.drawable.avd_close_to_search))
            if (fab.drawable is AnimatedVectorDrawable) {
                ((fab.drawable) as AnimatedVectorDrawable).start()
            }
            bottomAppBar.replaceMenu(R.menu.bottom_menu)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
        }
    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).apply {
            bottomAppBar.menu[0].icon = AnimatedVectorDrawableCompat.create(this,
                    R.drawable.delete_scale_down)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
        }
        mState = mLayoutManager.onSaveInstanceState()
    }

    override fun onItemSelected(position: Int, item: Album) {
        mViewModel.getAlbumInfo(item)
        (requireActivity() as MainActivity).startInfo()
    }


    companion object {
        fun newInstance(): NewReleasesFragment {
            val args = Bundle()
            val fragment = NewReleasesFragment()
            fragment.arguments = args
            return fragment
        }
    }
}