package com.example.sberify.presentation.ui

import android.animation.ObjectAnimator
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.widget.SearchView
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.sberify.R
import kotlinx.android.synthetic.main.bottom_app_bar.*


class SecondFragment : Fragment(R.layout.fragment_two) {

    private lateinit var mAlphaAnimator: ObjectAnimator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.suggestion_recycler)
        val searchView = view?.findViewById<SearchView>(R.id.search_view)
        mAlphaAnimator = ObjectAnimator.ofFloat(recyclerView, "alpha", 0f, 1f)
        mAlphaAnimator.apply {
            interpolator = DecelerateInterpolator()
            duration = 500
            repeatCount = 0
        }
        recyclerView?.apply {
            val mAdapter = SuggestionsAdapter()
            adapter = mAdapter
            mAdapter.submitList(
                    listOf("String1", "String2", "String3", "String4", "String5", "String6",
                            "String7"))
        }
        searchView?.setOnQueryTextFocusChangeListener { v, hasFocus ->
            recyclerView?.visibility = if (hasFocus) View.VISIBLE else View.GONE
            mAlphaAnimator.start()
        }
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                //recyclerView?.visibility = View.VISIBLE
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                recyclerView?.visibility = View.GONE
                return true
            }

        })
        return view
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).apply {
            fab.setImageDrawable(getDrawable(R.drawable.avd_search_to_close))
            if (fab.drawable is AnimatedVectorDrawable) {
                ((fab.drawable) as AnimatedVectorDrawable).start()
            }
            bottomAppBar.replaceMenu(R.menu.another_bottom_menu)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
        }
    }

    override fun onPause() {
        super.onPause()
        (requireActivity() as MainActivity).apply {
            bottomAppBar.menu[0].icon = AnimatedVectorDrawableCompat.create(this,
                    R.drawable.delete_scale_down)
            bottomAppBar.menu[1].icon = AnimatedVectorDrawableCompat.create(this,
                    R.drawable.delete_scale_down)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
        }
    }

    companion object {
        fun newInstance(): SecondFragment {
            val args = Bundle()
            val fragment = SecondFragment()
            fragment.arguments = args
            return fragment
        }
    }
}