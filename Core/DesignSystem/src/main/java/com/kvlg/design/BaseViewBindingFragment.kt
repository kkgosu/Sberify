package com.kvlg.design

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform

/**
 * @author Konstantin Koval
 * @since 07.07.2020
 */
abstract class BaseViewBindingFragment<T : ViewBinding> : Fragment() {

    protected var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getViewBinding(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            setPathMotion(MaterialArcMotion())
            duration = 450
        }
        exitTransition = Hold().apply {
            duration = 450
        }
        setupViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    protected fun setupAnimationsForRecyclers(vararg recyclers: RecyclerView) {
        recyclers.forEach {
            it.doOnNextLayout {
                startPostponedEnterTransition()
            }
        }
    }

    protected abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    protected abstract fun setupViews()

    protected fun showKeyboard() {
        val imm: InputMethodManager = requireContext().getSystemService()!!
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    protected fun hideKeyboard() {
        val imm: InputMethodManager = requireContext().getSystemService()!!
        imm.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }

    protected operator fun <T> LiveData<T>.invoke(consumer: (T) -> Unit) {
        observe(viewLifecycleOwner) { consumer(it) }
    }

    protected operator fun LiveData<Unit>.invoke(consumer: () -> Unit) {
        observe(viewLifecycleOwner) { consumer() }
    }
}