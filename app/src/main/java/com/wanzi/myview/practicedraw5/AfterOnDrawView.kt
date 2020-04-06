package com.wanzi.myview.practicedraw5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/06
 *     desc   :
 *     version: 1.0
 */
class AfterOnDrawView : AppCompatImageView {

    private val paint = Paint().apply {
        textSize = 28f
        color = Color.YELLOW
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (drawable != null) {
            canvas.save()
            canvas.concat(imageMatrix)
            canvas.drawText(
                "尺寸:${drawable.bounds.width()} x ${drawable.bounds.height()}",
                20f,
                40f,
                paint
            )
            canvas.restore()
        }
    }
}