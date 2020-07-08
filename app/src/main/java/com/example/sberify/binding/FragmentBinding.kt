package com.example.sberify.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment

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