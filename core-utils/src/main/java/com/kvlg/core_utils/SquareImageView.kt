package com.kvlg.core_utils

import android.content.Context
import android.util.AttributeSet

class SquareImageView(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}