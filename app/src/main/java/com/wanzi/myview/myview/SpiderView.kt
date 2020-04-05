package com.wanzi.myview.myview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/04
 *     desc   :
 *     version: 1.0
 */
class SpiderView : View {

    /**
     * 网格最大半径
     */
    private var radius = 0f

    /**
     * 中心x坐标
     */
    private var centerX = 0f

    /**
     * 中心y坐标
     */
    private var centerY = 0f

    /**
     * 总的边角数
     */
    private val corner = 6

    /**
     * 总的等级数
     */
    private val grade = 6

    /**
     * 数据
     */
    private val data = arrayOf(2,5,1,6,4,5)

    private val radarPaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.RED
        strokeWidth = 3f
    }

    private val regionPaint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
        alpha = 127
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        // 取宽高中最小的一个的90%当作网格最大直径
        radius = (min(w, h) * 0.9 / 2).toFloat()
        // 中心坐标
        centerX = (w / 2).toFloat()
        centerY = (h / 2).toFloat()

        postInvalidate()
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 移动到屏幕中心点
        canvas.translate(centerX, centerY)

        drawPolygon(canvas)
        drawLine(canvas)
        drawRegion(canvas)
    }

    /**
     * 绘制网格
     */
    private fun drawPolygon(canvas: Canvas) {
        // 单位角度
        val unitAngle = 360 / corner
        // 单位半径
        val unitRadius = radius / grade

        val path = Path()

        for (i in 1..grade) {
            // 当前半径
            val currentRadius = i * unitRadius

            path.reset()
            for (j in 0 until corner) {
                // 当前角度
                val currentAngle = j * unitAngle
                // 当前弧度
                val radians = Math.toRadians(currentAngle.toDouble())

                val x = currentRadius * cos(radians).toFloat()
                val y = currentRadius * sin(radians).toFloat()

                if (j == 0) {
                    path.moveTo(x, y)
                } else {
                    path.lineTo(x, y)
                }

            }
            path.close()
            canvas.drawPath(path, radarPaint)
        }
    }

    /**
     * 绘制中线
     */
    private fun drawLine(canvas: Canvas) {
        val path = Path()
        // 单位角度
        val unitAngle = 360 / corner
        for (i in 0 until corner) {
            path.reset()
            // 当前角度
            val currentAngle = i * unitAngle
            // 当前弧度
            val radians = Math.toRadians(currentAngle.toDouble())

            val x = radius * cos(radians).toFloat()
            val y = radius * sin(radians).toFloat()

            path.moveTo(0f, 0f)
            path.lineTo(x, y)
            canvas.drawPath(path, radarPaint)
        }
    }

    /**
     * 绘制区域
     */
    private fun drawRegion(canvas: Canvas) {
        val path = Path()
        // 单位半径
        val unitRadius = radius / grade
        // 单位角度
        val unitAngle = 360 / corner
        for (i in 0 until corner) {
            // 当前半径
            val currentRadius = data[i] * unitRadius
            // 当前角度
            val currentAngle = i * unitAngle
            // 当前弧度
            val radians = Math.toRadians(currentAngle.toDouble())

            val x = currentRadius * cos(radians).toFloat()
            val y = currentRadius * sin(radians).toFloat()

            canvas.drawCircle(x, y, 10f, regionPaint)

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }
        canvas.drawPath(path, regionPaint)
    }
}