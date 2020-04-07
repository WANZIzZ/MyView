package com.wanzi.myview.myview.pathmeasure

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.abs

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/07
 *     desc   :
 *     version: 1.0
 */
class GetSegmentView : View {

    private val circlePath = Path().apply {
        addCircle(100f, 100f, 50f, Path.Direction.CW)
    }
    private val dstPath = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        strokeWidth = 4f
        style = Paint.Style.STROKE
    }

    private val pathMeasure = PathMeasure()

    private var curAnimValue = 0f

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
    }

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        pathMeasure.setPath(circlePath, true)

        ValueAnimator.ofFloat(0f, 1f).apply {
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                curAnimValue = it.animatedValue as Float
                invalidate()
            }
            duration = 2000
            start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val stop = pathMeasure.length * curAnimValue
        val start = (stop - (0.5 - abs(curAnimValue - 0.5)) * pathMeasure.length).toFloat()

        dstPath.reset()
        pathMeasure.getSegment(0f, stop, dstPath, true)

        canvas.drawPath(dstPath, paint)
    }
}