package com.wanzi.myview.practicedraw2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/01
 *     desc   :
 *     version: 1.0
 */
class FillPathView : View {

    private val paint = Paint()
    private val path = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

    //    paint.style = Paint.Style.FILL_AND_STROKE
    //    paint.style = Paint.Style.STROKE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 50f
        canvas?.translate(100f, 100f)
        path.rLineTo(200f, 200f)
        path.rLineTo(200f, -200f)
        path.rLineTo(200f, 200f)
        path.rLineTo(200f, -200f)
        canvas?.drawPath(path, paint)

        canvas?.translate(0f, 500f)
        val path2 = Path()
        paint.getFillPath(path, path2)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 0f
        canvas?.drawPath(path2, paint)

    }
}