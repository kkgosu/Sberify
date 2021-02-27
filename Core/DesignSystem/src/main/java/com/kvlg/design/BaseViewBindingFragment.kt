package com.kvlg.design

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.getSystemService
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialElevationScale

/**
 * @author Konstantin Koval
 * @since 07.07.2020
 */
abstract class BaseViewBindingFragment<T : ViewBinding> : Fragment() {

    protected var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSharedElementTransitions()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getViewBinding(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()
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

    protected fun Fragment.setupToolbar(toolbar: Toolbar, block: (ActionBar.() -> Unit)? = null) {
        (requireActivity() as AppCompatActivity).run {
            setSupportActionBar(toolbar)
            supportActionBar?.run { block?.invoke(this) }
        }
    }

    protected fun Fragment.setToolbarTitle(title: String) {
        (requireActivity() as AppCompatActivity).supportActionBar!!.title = title
    }

    protected fun Fragment.shortToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    protected fun Fragment.setSharedElementTransitions(
        enterTransitionSetup: (MaterialContainerTransform.() -> Unit)? = null,
        returnTransitionSetup: (MaterialContainerTransform.() -> Unit)? = null,
    ) {
        val context = requireContext()
        sharedElementEnterTransition = context.buildSharedElementTransition(enterTransitionSetup)
        sharedElementReturnTransition = context.buildSharedElementTransition(returnTransitionSetup)
        setExitSharedElementTransition()
    }

    private fun Fragment.setExitSharedElementTransition() {
        exitTransition = MaterialElevationScale(/* growing= */ false).apply {
            duration = SHARED_ELEMENT_TRANSITION_DURATION
        }
        reenterTransition = MaterialElevationScale(/* growing= */ true).apply {
            duration = SHARED_ELEMENT_TRANSITION_DURATION
        }
    }

    private fun Context.buildSharedElementTransition(
        setup: (MaterialContainerTransform.() -> Unit)?
    ): MaterialContainerTransform {
        val shapeAppearance = ShapeAppearanceModel().withCornerSize(dpToPx(16).toFloat())
        return MaterialContainerTransform().apply {
            startShapeAppearanceModel = shapeAppearance
            duration = SHARED_ELEMENT_TRANSITION_DURATION
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            containerColor = getAttributeColor(android.R.attr.colorBackground)
            setup?.invoke(this)
        }
    }

    private fun Context.getAttributeColor(@AttrRes attrRes: Int): Int {
        val typedValue = TypedValue()
        this.theme.resolveAttribute(attrRes, typedValue, true)
        return typedValue.data
    }

    private fun Context.dpToPx(dpValue: Int): Int = (dpValue * resources.displayMetrics.density).toInt()

    companion object {
        private const val SHARED_ELEMENT_TRANSITION_DURATION = 400L
    }
}