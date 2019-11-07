package com.example.sberify.presentation.ui

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
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
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.sberify.R
import kotlinx.android.synthetic.main.bottom_app_bar.*

class NewReleasesFragment : Fragment(R.layout.fragment_new_releases) {

    private lateinit var mViewModel: SharedViewModel
    private lateinit var mAdapter: NewReleasesAdapter
    private lateinit var root: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        root = super.onCreateView(inflater, container, savedInstanceState) as RecyclerView
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mAdapter = NewReleasesAdapter()
        root.adapter = mAdapter
        root.layoutManager = GridLayoutManager(requireContext(), 2)

        mViewModel = ViewModelProvider(requireActivity())
                .get(SharedViewModel::class.java)
        mViewModel.newReleases.observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)
        })
    }

    override fun onResume() {
        super.onResume()
        val activity = (requireActivity() as MainActivity)
        activity.bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
    }

    override fun onPause() {
        super.onPause()
        val activity = (requireActivity() as MainActivity)
        activity.apply {
            fab.setImageDrawable(activity.getDrawable(R.drawable.edit_to_reply))
            if (fab.drawable is AnimatedVectorDrawable) {
                ((fab.drawable) as AnimatedVectorDrawable).start()
            }
            bottomAppBar.menu[0].icon =
                    AnimatedVectorDrawableCompat.create(this,
                            R.drawable.delete_scale_down)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
            bottomAppBar.replaceMenu(R.menu.another_bottom_menu)
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