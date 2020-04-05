package com.wanzi.myview.myview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/03
 *     desc   :
 *     version: 1.0
 */
class RectPointView : View {

    private var mPaint: Paint = Paint()
    private lateinit var mRect: Rect
    private var mX = -1f
    private var mY = -1f

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    init {
        mPaint.style = Paint.Style.STROKE
        mRect = Rect(100, 10, 300, 100)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        mX = event.x
        mY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                invalidate()
                return true
            }
            MotionEvent.ACTION_UP -> {
                mX = -1f
                mY = -1f
            }
        }

        postInvalidate()
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        mPaint.color = if (mRect.contains(mX.toInt(), mY.toInt())) {
            Color.RED
        } else {
            Color.GREEN
        }

        canvas.drawRect(mRect, mPaint)
    }
}