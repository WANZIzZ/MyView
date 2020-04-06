package com.wanzi.myview.practicedraw5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/06
 *     desc   :
 *     version: 1.0
 */
class DispatchDrawLayout : LinearLayoutCompat {

    private val paint = Paint().apply {
        color = Color.RED
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)

        canvas.drawCircle(50f, 50f, 30f, paint)
        canvas.drawCircle(150f, 150f, 30f, paint)
        canvas.drawCircle(250f, 250f, 30f, paint)
        canvas.drawCircle(350f, 350f, 30f, paint)
        canvas.drawCircle(450f, 450f, 30f, paint)
    }

}