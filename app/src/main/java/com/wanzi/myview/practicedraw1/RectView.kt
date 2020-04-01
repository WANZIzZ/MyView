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
class RectView : View {

    private val paint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawRect() 方法画矩形

        canvas?.drawRect(50f, 50f, 450f, 450f, paint)
    }
}