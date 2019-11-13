package com.example.sberify.presentation.ui

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.sberify.R
import kotlinx.android.synthetic.main.bottom_app_bar.*


class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var mSuggestionsRecycler: RecyclerView
    private lateinit var mSuggestionsAdapter: SuggestionsAdapter
    private val list = listOf("Lorem", "Ipsum", "simply", "dummy", "text", "printing",
            "typesetting")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        mSuggestionsRecycler = view?.findViewById(R.id.suggestion_recycler)!!
        val searchView = view.findViewById<SearchView>(R.id.search_view)

        mSuggestionsAdapter = SuggestionsAdapter()
        mSuggestionsRecycler.apply {
            adapter = mSuggestionsAdapter
            mSuggestionsAdapter.submitList(list)
        }

        configureSearchView(searchView)
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

    private fun configureSearchView(searchView: SearchView?) {
        searchView?.setOnQueryTextFocusChangeListener { _, hasFocus ->
            mSuggestionsRecycler.visibility = if (hasFocus) {
                mSuggestionsRecycler.scheduleLayoutAnimation()
                View.VISIBLE
            } else {
                View.GONE
            }
        }
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { query ->
                    mSuggestionsAdapter.submitList(list.filter { it.contains(query, true) })
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                mSuggestionsRecycler.visibility = View.GONE
                return true
            }

        })
    }

    companion object {
        fun newInstance(): SearchFragment {
            val args = Bundle()
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }
}