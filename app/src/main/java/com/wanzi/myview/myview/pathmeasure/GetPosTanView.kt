package com.wanzi.myview.myview.pathmeasure

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanzi.myview.R
import kotlin.math.atan2

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/07
 *     desc   :
 *     version: 1.0
 */
class GetPosTanView : View {

    private val paint = Paint().apply {
        strokeWidth = 4f
        style = Paint.Style.STROKE
    }

    private val dstPath = Path()

    private val circlePath = Path().apply {
        addCircle(100f, 100f, 50f, Path.Direction.CW)
    }

    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.arrow)

    private val pathMeasure = PathMeasure()

    private val mMatrix = Matrix()

    private var curAnimValue = 0f

    private val pos = FloatArray(2)
    private val tan = FloatArray(2)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

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

        mMatrix.reset()
        dstPath.reset()

        val stop = curAnimValue * pathMeasure.length

        pathMeasure.getSegment(0f, stop, dstPath, true)
        pathMeasure.getPosTan(stop, pos, tan)
        val degrees = atan2(tan[1], tan[0]) * 180 / Math.PI.toFloat()

        mMatrix.postRotate(degrees, bitmap.width / 2.toFloat(), bitmap.height / 2.toFloat())

        mMatrix.postTranslate(pos[0] - bitmap.width / 2, pos[1] - bitmap.height / 2)

        canvas.drawPath(dstPath, paint)
        canvas.drawBitmap(bitmap, mMatrix, paint)
    }
}