package com.wanzi.myview.practicedraw5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/06
 *     desc   :
 *     version: 1.0
 */
class OnDrawForegroundView : AppCompatImageView {

    private val paint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDrawForeground(canvas: Canvas) {
        // BeforeOnDrawForegroundView
        paint.color = Color.RED
        canvas.drawRect(0f, 20f, 300f, 80f, paint)

        paint.textSize = 36f
        paint.color = Color.WHITE
        canvas.drawText("Hello World", 20f, 60f, paint)

        super.onDrawForeground(canvas)

        // AfterOnDrawForegroundView

        /*paint.color = Color.RED
        canvas.drawRect(0f, 20f, 300f, 80f, paint)

        paint.textSize = 36f
        paint.color = Color.WHITE
        canvas.drawText("Hello World", 20f, 60f, paint)*/
    }
}