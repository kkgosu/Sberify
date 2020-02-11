package com.example.sberify.presentation.ui

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.OnRebindCallback
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.example.sberify.R
import com.example.sberify.presentation.ui.utils.inflateLayout
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment(), Interaction {

    lateinit var sharedViewModel: SharedViewModel
    lateinit var binding: ViewDataBinding
    lateinit var mView: View

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity()).get(
                SharedViewModel::class.java)
    }

    fun <T : ViewDataBinding> initBinding(@LayoutRes id: Int, container: ViewGroup?): T {
        binding = inflateLayout(id, container)
        binding.lifecycleOwner = viewLifecycleOwner
        mView = binding.root
        return binding as T
    }

    fun setupAnimations() {
        postponeEnterTransition()
        exitTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.fade)
        sharedElementEnterTransition = TransitionInflater.from(context)
                .inflateTransition(R.transition.image_shared_element_transition)
        sharedElementReturnTransition = TransitionInflater.from(context)
                .inflateTransition(R.transition.image_shared_element_transition)
    }

    fun <T : ViewDataBinding> invalidateBindings() {
        binding.invalidateAll()
        binding.addOnRebindCallback(object : OnRebindCallback<T>() {
            override fun onBound(binding: T) {
                startPostponedEnterTransition()
            }
        })
    }
    
    fun setupToolbar() {
        val toolbar = mView.findViewById<Toolbar>(R.id.collapsed_toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setFavoriteIcon(imageButton: ImageButton, isFavorite: Boolean) {
        with(imageButton) {
            setImageDrawable(
                if (isFavorite) {
                    (requireContext().getDrawable(
                        R.drawable.avd_heart_to_filled
                    ))
                } else {
                    requireContext().getDrawable(
                        R.drawable.avd_filled_heart_break
                    )
                }
            )
        }
    }

    fun startAnim(imageButton: ImageButton) {
        with(imageButton) {
            (drawable as AnimatedVectorDrawable).start()
        }
    }
}