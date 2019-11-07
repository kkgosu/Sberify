package com.example.sberify.presentation.ui

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.sberify.R
import kotlinx.android.synthetic.main.bottom_app_bar.*

class SecondFragment : Fragment(R.layout.fragment_two) {

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).apply {
            fab.setImageDrawable(getDrawable(R.drawable.edit_to_reply))
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