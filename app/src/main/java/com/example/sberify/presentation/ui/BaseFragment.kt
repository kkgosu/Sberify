package com.example.sberify.presentation.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
}