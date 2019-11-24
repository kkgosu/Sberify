package com.example.sberify.presentation.ui.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class SquareImageView(context: Context, attrs: AttributeSet) : ImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}