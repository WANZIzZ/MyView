package com.wanzi.myview.practicedraw5

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/06
 *     desc   :
 *     version: 1.0
 */
class BeforeOnDrawView : AppCompatTextView {

    private val paint = Paint().apply {
        color = Color.YELLOW
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {

        canvas.drawRect(
            RectF(
                layout.getLineLeft(1),
                layout.getLineTop(1).toFloat(),
                layout.getLineRight(1),
                layout.getLineBottom(1).toFloat()
            ), paint
        )

        super.onDraw(canvas)
    }
}