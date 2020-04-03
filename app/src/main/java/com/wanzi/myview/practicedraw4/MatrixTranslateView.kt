package com.wanzi.myview.practicedraw4

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
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
class MatrixTranslateView : View {

    private val paint = Paint()
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private val matrix = object : Matrix() {

    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()

        matrix.postTranslate(600f, 300f)
        matrix.postScale(0.5f, 0.5f)
        matrix.postRotate(30f)
        matrix.postSkew(0f, 0.5f)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
    }
}