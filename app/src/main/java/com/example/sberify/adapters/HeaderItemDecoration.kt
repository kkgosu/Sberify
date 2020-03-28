package com.example.sberify.adapters

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class HeaderItemDecoration(
    context: Context,
    parent: RecyclerView,
    @LayoutRes resId: Int
) : RecyclerView.ItemDecoration() {

    private var layout: View = LayoutInflater.from(context).inflate(resId, parent, false)

    init {
        layout.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        layout.layout(parent.left, 0, parent.right, layout.measuredHeight)

        println(parent.childCount)
        for (i in 0..parent.childCount) {
            val view = parent.getChildAt(i)
            if (parent.getChildAdapterPosition(view) == 1) {
                c.save()
                val height = layout.measuredHeight
                val top = view.top - height
                c.translate(0F, top.toFloat())
                layout.draw(c)
                c.restore()
                break
            }
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.set(0, layout.measuredHeight, 0, 0)
        } else {
            outRect.setEmpty();
        }
    }

}