package com.wanzi.myview.practicedraw2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/01
 *     desc   :
 *     version: 1.0
 */
class StrokeMiterView : View {

    private val paint = Paint()
    private val path = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.let {
            it.strokeWidth = 40f
            it.style = Paint.Style.STROKE
        }

        canvas.translate(100f, 100f)

        paint.strokeMiter = 1f
        path.let {
            it.lineTo(200f, 0f)
            it.rLineTo(0f, 150f)
        }

        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)

        paint.strokeMiter = 0f
        path.let {
            it.lineTo(200f, 0f)
            it.rLineTo(0f, 150f)
        }

        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)

        paint.strokeMiter = 1.6f
        path.let {
            it.lineTo(200f, 0f)
            it.rLineTo(0f, 150f)
        }

        canvas.drawPath(path, paint)
    }
}