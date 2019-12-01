package com.example.sberify.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.sberify.R
import com.example.sberify.presentation.ui.ViewModelFactory
import com.example.sberify.presentation.ui.albuminfo.AlbumInfoAdapter

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: AlbumInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteViewModel = ViewModelProvider(this,
                ViewModelFactory())
                .get(FavoriteViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        mAdapter = AlbumInfoAdapter()
        recyclerView = view!!.findViewById(R.id.favorite_recycler)
        recyclerView.adapter = mAdapter

        favoriteViewModel.favorite.observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)
        })
        favoriteViewModel.loadFavorite()
        return view
    }

    companion object {
        fun newInstance(): FavoriteFragment {
            val args = Bundle()
            val fragment = FavoriteFragment()
            fragment.arguments = args
            return fragment
        }
    }
}