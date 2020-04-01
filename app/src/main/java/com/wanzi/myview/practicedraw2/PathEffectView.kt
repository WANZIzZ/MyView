package com.wanzi.myview.practicedraw2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/01
 *     desc   :
 *     version: 1.0
 */
class PathEffectView : View {

    private val paint = Paint()
    private val path = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3f
        path.rLineTo(50f, 150f)
        path.rLineTo(80f, -180f)
        path.rLineTo(120f, 200f)
        path.rLineTo(180f, -220f)
        path.rLineTo(200f, 230f)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {

            it.save()

            it.translate(100f, 100f)

            paint.pathEffect = CornerPathEffect(50f)
            it.drawPath(path, paint)

            it.restore()

            it.save()

            it.translate(100f, 300f)
            paint.pathEffect = DiscretePathEffect(20f, 20f)
            it.drawPath(path, paint)

            it.restore()

            it.save()

            it.translate(100f, 500f)
            paint.pathEffect = DashPathEffect(floatArrayOf(20f, 20f), 50f)
            it.drawPath(path, paint)

            it.restore()

            it.save()

            it.translate(100f, 700f)
            paint.pathEffect = PathDashPathEffect(
                Path().apply {
                    moveTo(0f, 0f)
                    lineTo(0f, 50f)
                    lineTo(50f, 0f)
                },
                50f,
                10f,
                PathDashPathEffect.Style.MORPH
            )
            it.drawPath(path, paint)
            it.restore()

            it.save()

            it.translate(100f, 900f)
            paint.pathEffect = SumPathEffect(
                DiscretePathEffect(20f, 20f),
                DashPathEffect(floatArrayOf(20f, 20f), 50f)
            )
            it.drawPath(path, paint)

            it.restore()

            it.save()

            it.translate(100f, 1100f)
            paint.pathEffect = ComposePathEffect(
                DashPathEffect(floatArrayOf(20f, 20f), 50f),
                DiscretePathEffect(20f, 20f)
            )
            it.drawPath(path, paint)

            it.restore()
        }
    }
}