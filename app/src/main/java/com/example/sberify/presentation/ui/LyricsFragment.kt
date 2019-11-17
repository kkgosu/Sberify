package com.example.sberify.presentation.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.R

class LyricsFragment : Fragment(R.layout.fragment_lyrics) {

    private lateinit var mSharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        mSharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val lyricsTextView = view!!.findViewById<TextView>(R.id.lyrics)
        lyricsTextView.movementMethod = ScrollingMovementMethod()
        mSharedViewModel.lyrics.observe(viewLifecycleOwner, Observer {
            lyricsTextView.text = it
        })
        return view
    }

    companion object {
        fun newInstance(): LyricsFragment {
            val args = Bundle()
            val fragment = LyricsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}