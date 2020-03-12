package com.example.sberify.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

fun Fragment.simpleToolbarWithHome(toolbar: MaterialToolbar, title_: String? = "") {
    (requireActivity() as AppCompatActivity).apply {
        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = title_
        }
    }
}

@BindingAdapter("simpleToolbarWithHome", "simpleToolbarTitle")
fun bindToolbarWithTitle(toolbar: MaterialToolbar, fragment: Fragment, title: String?) {
    fragment.simpleToolbarWithHome(toolbar, title)
}