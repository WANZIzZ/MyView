package com.wanzi.myview.practicedraw1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/03/31
 *     desc   :
 *     version: 1.0
 */
class ArcView : View {

    private val paint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        paint.style = Paint.Style.STROKE
        canvas?.drawArc(100f, 100f, 700f, 500f, -120f, -60f, false, paint)

        paint.style = Paint.Style.FILL
        canvas?.drawArc(100f, 100f, 700f, 500f, -20f, -90f, true, paint)

        canvas?.drawArc(100f, 100f, 700f, 500f, 30f, 120f, false, paint)
    }
}