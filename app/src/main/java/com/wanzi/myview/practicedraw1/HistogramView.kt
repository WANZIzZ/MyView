package com.wanzi.myview.practicedraw1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/03/31
 *     desc   :
 *     version: 1.0
 */
class HistogramView : View {

    private val paint = Paint()
    private val path = Path()
    private val versions =
        arrayOf(
            Rect(40, 697, 100, 699),
            Rect(120, 670, 180, 699),
            Rect(200, 670, 260, 699),
            Rect(280, 500, 340, 699),
            Rect(360, 400, 420, 699),
            Rect(440, 300, 500, 699),
            Rect(520, 520, 580, 699)
        )
    private val versionsName = arrayOf("Froyo", "GB", "ICS", "JB", "KitKat", "L", "M")

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        // 画坐标轴

        // 如果是直接用 path 画线，必须设置 paint 的样式为 STROKE
        // 如果是前面用 path 画了别的以后再画线，那么就不必再设置 paint 的样式了
        paint.style = Paint.Style.STROKE
        path.moveTo(20f, 200f)
        path.lineTo(20f, 700f)
        path.rLineTo(1000f, 0f)
        canvas?.drawPath(path, paint)


        // 画柱状
        versions.forEachIndexed { index, rect ->
            paint.style = Paint.Style.FILL
            paint.color = Color.GREEN
            canvas?.drawRect(rect, paint)

            // 柱状底部文字
            paint.color = Color.BLACK
            paint.textSize = 16f
            val versionName = versionsName[index]
            val x = when (versionName.length) {
                1 -> 24
                2 -> 20
                3 -> 16
                else -> 10
            }
            canvas?.drawText(
                versionName,
                (rect.left + x).toFloat(),
                (rect.bottom + 20).toFloat(),
                paint
            )
        }

        // 最底部文字
        paint.textSize = 64f
        canvas?.drawText("直方图", 400f, 1000f, paint)
    }
}