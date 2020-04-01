package com.wanzi.myview.practicedraw1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/03/31
 *     desc   :
 *     version: 1.0
 */
class PieChartView : View {

    private val paint = Paint()
    private val path = Path()

    private val items = arrayOf(
        Item("Lollipop", 0.375F, Color.RED),
        Item("Marshmallow", 0.125F, Color.YELLOW),
        Item("Froyo", 0.001F, Color.WHITE),
        Item("Gingerbread", 0.04F, Color.LTGRAY),
        Item("Ice Cream Sandwich", 0.04F, Color.GRAY),
        Item("Jelly Bean", 0.14F, Color.GREEN),
        Item("KitKat", 0.279F, Color.BLUE)
    )

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        var startAngle = -180F
        items.forEach {
            paint.color = it.color
            val sweepAngle = it.scale * 360

            val radians = Math.toRadians(sweepAngle.toDouble() / 2 + startAngle)

            val xx = (20 * cos(radians)).toFloat()
            val yy = (20 * sin(radians)).toFloat()

            canvas?.drawArc(
                200f + xx,
                300f + yy,
                800f + xx,
                900f + yy,
                startAngle,
                sweepAngle,
                true,
                paint
            )

            val x = (500 + 320 * cos(radians)).toFloat()
            val y = (600 + 320 * sin(radians)).toFloat()

            val newX = (500 + 350 * cos(radians)).toFloat()
            val newY = (600 + 350 * sin(radians)).toFloat()

            paint.color = Color.BLACK
            paint.strokeWidth = 3f
            canvas?.drawLine(x, y, newX, newY, paint)

            paint.textSize = 16f
            if (newX > 500) {
                canvas?.drawLine(newX, newY, newX + 50f, newY, paint)
                canvas?.drawText(it.name, newX + 60f, newY, paint)
            } else {
                canvas?.drawLine(newX, newY, newX - 50f, newY, paint)
                canvas?.drawText(it.name, newX - 120f, newY, paint)
            }

            startAngle += sweepAngle
        }


        paint.textSize = 48f
        canvas?.drawText("饼图", 450f, 1000f, paint)
    }

    data class Item(
        val name: String,
        val scale: Float,
        val color: Int
    )
}