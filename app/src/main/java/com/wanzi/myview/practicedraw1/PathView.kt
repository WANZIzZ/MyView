package com.wanzi.myview.practicedraw1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/03/31
 *     desc   :
 *     version: 1.0
 */
class PathView : View {

    private val paint = Paint()
    private val path = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawPath() 方法画心形

        paint.style = Paint.Style.FILL

        // 这里要注意画笔的连贯
        // 如果角度没有设置好，可能会导致笔画顺序不对
        path.arcTo(250f, 250f, 500f, 500f, -210f, 210f, false)
        path.arcTo(500f, 250f, 750f, 500f, -180f, 210f, false)

        path.lineTo(500f, 650f)

        canvas?.drawPath(path, paint)
    }
}