package com.example.sberius

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.bottom_app_bar.*

class OneFragment : Fragment(R.layout.fragment_one) {

    override fun onResume() {
        super.onResume()
        val activity = (requireActivity() as MainActivity)
        activity.bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
    }
    
    override fun onPause() {
        super.onPause()
        val activity = (requireActivity() as MainActivity)
        activity.apply {
            fab.setImageDrawable(activity.getDrawable(R.drawable.edit_to_reply))
            if (fab.drawable is AnimatedVectorDrawable) {
                ((fab.drawable) as AnimatedVectorDrawable).start()
            }
            bottomAppBar.menu[0].icon =
                AnimatedVectorDrawableCompat.create(this, R.drawable.delete_scale_down)
            bottomAppBar.menu.forEach { (it.icon as? Animatable)?.start() }
            bottomAppBar.replaceMenu(R.menu.another_bottom_menu)
        }
    }

    companion object {
        fun newInstance(): OneFragment {
            val args = Bundle()
            val fragment = OneFragment()
            fragment.arguments = args
            return fragment
        }
    }
}