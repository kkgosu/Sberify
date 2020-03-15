package com.example.sberify.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lyrics.*

fun Fragment.simpleToolbarWithHome(toolbar: Toolbar, title_: String? = "") {
    (requireActivity() as AppCompatActivity).apply {
        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = title_
        }
    }
}

@BindingAdapter("simpleToolbarWithHome", "simpleToolbarTitle")
fun bindToolbarWithTitle(toolbar: Toolbar, fragment: Fragment, title: String?) {
    fragment.simpleToolbarWithHome(toolbar, title)
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