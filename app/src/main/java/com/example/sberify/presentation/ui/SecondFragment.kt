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
        val activity = (requireActivity() as MainActivity)
        activity.bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
    }

    override fun onPause() {
        super.onPause()
        val activity = (requireActivity() as MainActivity)
        activity.apply {
            fab.setImageDrawable(getDrawable(R.drawable.reply_to_edit))
            if (fab.drawable is AnimatedVectorDrawable) {
                ((fab.drawable) as AnimatedVectorDrawable).start()
            }
            bottomAppBar.menu[0].icon =
                AnimatedVectorDrawableCompat.create(this,
                    R.drawable.delete_scale_down
                )
            bottomAppBar.menu[1].icon =
                AnimatedVectorDrawableCompat.create(this,
                    R.drawable.delete_scale_down
                )
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
            bottomAppBar.replaceMenu(R.menu.bottom_menu)
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