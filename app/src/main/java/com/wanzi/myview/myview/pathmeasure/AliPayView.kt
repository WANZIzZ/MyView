package com.wanzi.myview.myview.pathmeasure

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/07
 *     desc   :
 *     version: 1.0
 */
class AliPayView : View {

    private val circlePath = Path().apply {
        addCircle(200f, 200f, 100f, Path.Direction.CW)

        moveTo(150f, 200f)
        lineTo(200f, 250f)
        lineTo(250f, 200 - 100 / 3f)
    }

    private val dstPath = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        strokeWidth = 4f
        style = Paint.Style.STROKE
    }

    private val pathMeasure = PathMeasure()

    private var curAnimValue = 0f

    private var isCircleOver = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        pathMeasure.setPath(circlePath, false)

        ValueAnimator.ofFloat(0f, 2f).apply {
            addUpdateListener {
                curAnimValue = it.animatedValue as Float
                invalidate()
            }
            duration = 4000
            start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        when {
            curAnimValue < 1 -> {
                Log.d("Wanzi", "小于1 $curAnimValue")
                val stop = curAnimValue * pathMeasure.length
                pathMeasure.getSegment(0f, stop, dstPath, true)
            }
            !isCircleOver -> {
                Log.d("Wanzi", "等于1 $curAnimValue")
                pathMeasure.getSegment(0f, pathMeasure.length, dstPath, true)
                pathMeasure.nextContour()
                isCircleOver = true
            }
            else -> {
                Log.d("Wanzi", "大于1 $curAnimValue")
                val stop = (curAnimValue - 1) * pathMeasure.length
                pathMeasure.getSegment(0f, stop, dstPath, true)
            }
        }

        canvas.drawPath(dstPath, paint)
    }
}