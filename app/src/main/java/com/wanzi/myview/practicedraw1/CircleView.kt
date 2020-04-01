package com.wanzi.myview.practicedraw1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
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
class CircleView : View {

    private val paint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        canvas?.drawCircle(200f, 200f, 100f, paint)

        paint.style = Paint.Style.STROKE

        canvas?.drawCircle(600f, 200f, 100f, paint)

        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL

        canvas?.drawCircle(200f, 600f, 100f, paint)

        paint.strokeWidth = 20f
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas?.drawCircle(600f, 600f, 100f, paint)

    }
}