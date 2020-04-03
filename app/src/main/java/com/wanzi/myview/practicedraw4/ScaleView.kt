package com.wanzi.myview.practicedraw4

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.wanzi.myview.R

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/03
 *     desc   :
 *     version: 1.0
 */
class ScaleView : View {

    private val paint = Paint()
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.strokeWidth = 30f

        canvas.drawPoint(250f, 0f, paint)
        canvas.drawPoint(500f, 0f, paint)

        canvas.drawPoint(0f, 250f, paint)
        canvas.drawPoint(0f, 500f, paint)

        canvas.drawPoint(100f, 100f, paint)

        canvas.save()

        canvas.scale(0.5f, 0.5f, 100f, 100f)
        canvas.drawBitmap(bitmap, 500f, 500f, paint)

        canvas.restore()

        canvas.drawBitmap(bitmap, 500f, 500f, paint)
    }
}