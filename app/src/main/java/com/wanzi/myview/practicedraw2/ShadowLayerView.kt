package com.wanzi.myview.practicedraw2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
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
class ShadowLayerView : View {

    private val paint = Paint()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        paint.textSize = 96f

        paint.setShadowLayer(10f,10f,10f,Color.RED)

        canvas?.drawText("Hello World", 200f, 200f, paint)
    }
}