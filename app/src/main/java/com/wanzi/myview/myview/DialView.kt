package com.wanzi.myview.myview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/02
 *     desc   : 自己写的一个刻度盘，模仿 https://github.com/kangdp/TptDialSample
 *     version: 1.0
 */
class DialView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val shader =
        SweepGradient(0f, 0f, Color.parseColor("#113DEE"), Color.parseColor("#00FFFF"))
    private val effect = DashPathEffect(floatArrayOf(5f, 20f), 0f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        /*canvas.translate((width / 2).toFloat(), (height / 2).toFloat())

        paint.style = Paint.Style.STROKE
        //  paint.shader = shader
        //   paint.pathEffect = effect

        canvas.drawRect(-300f, -300f, 300f, 300f, paint)

        paint.style = Paint.Style.FILL
        for (i in 1..70) {
            canvas.rotate(10f, 50f, 50f)
            canvas.drawArc(-300f, -300f, 300f, 300f, 0f, 5f, true, paint)
        }

        canvas.drawPath(path, paint)*/

        canvas.translate(300f, 300f)

        paint.textSize = 200f
        paint.style = Paint.Style.STROKE

        val bounds1 = Rect()
        paint.getTextBounds("ij", 0, 2, bounds1)

        canvas.drawText("ij", 0f, 0f, paint)

        canvas.drawRect(bounds1, paint)
    }
}