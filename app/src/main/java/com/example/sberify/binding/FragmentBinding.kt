package com.example.sberify.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lyrics.*

fun Fragment.simpleToolbarWithHome(toolbar: Toolbar) {
    (requireActivity() as AppCompatActivity).apply {
        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }
    }
}

@BindingAdapter("simpleToolbarWithHome")
fun bindToolbarWithTitle(toolbar: Toolbar, fragment: Fragment) {
    fragment.simpleToolbarWithHome(toolbar)
}

@BindingAdapter("simpleToolbar", "toolbarTitle")
fun bindToolbar(toolbar: Toolbar, fragment: Fragment, title_: String?) {
    fragment.run {
        back.setOnClickListener {
            (requireActivity() as AppCompatActivity).onBackPressed()
        }

        title.text = title_
    }
}