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
class RoundRectView : View {

    private val paint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        canvas?.drawRoundRect(100f, 100f, 500f, 300f, 20f, 20f, paint)
    }
}