package com.wanzi.myview.practicedraw2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/01
 *     desc   :
 *     version: 1.0
 */
class SweepGradientView : View {

    private val paint = Paint()
    private val shader =
        SweepGradient(300f, 300f, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"))

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3

        paint.shader = shader
        canvas?.drawCircle(300f, 300f, 200f, paint)
    }
}