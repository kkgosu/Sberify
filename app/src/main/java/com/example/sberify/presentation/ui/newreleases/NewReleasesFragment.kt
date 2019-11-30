package com.example.sberify.presentation.ui.newreleases

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.sberify.R
import com.example.sberify.domain.model.Album
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoFragment
import com.example.sberify.presentation.ui.MainActivity
import com.example.sberify.presentation.ui.SharedViewModel
import kotlinx.android.synthetic.main.bottom_app_bar.*


class NewReleasesFragment : Fragment(
        R.layout.fragment_new_releases), NewReleasesAdapter.Interaction {

    private lateinit var mViewModel: SharedViewModel
    private lateinit var mAdapter: NewReleasesAdapter
    private lateinit var mLayoutManager: StaggeredGridLayoutManager
    private lateinit var mRecyclerView: RecyclerView
    private var mState: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity()).get(
                SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        mRecyclerView = super.onCreateView(inflater, container, savedInstanceState) as RecyclerView
        mAdapter = NewReleasesAdapter(this)
        mLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        mRecyclerView.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
            mLayoutManager.onRestoreInstanceState(mState)
        }
        
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

    override fun onItemSelected(item: Album, view: View) {
        mViewModel.getAlbumInfo(item)
        requireActivity().supportFragmentManager.commit {
            addSharedElement(view.findViewById(R.id.release_name), item.name)
            addSharedElement(view.findViewById(R.id.release_cover), item.id)
            addSharedElement(view.findViewById(R.id.artist_name), item.artist.name)
            replace(R.id.root, AlbumInfoFragment.newInstance())
            addToBackStack(null)
        }
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