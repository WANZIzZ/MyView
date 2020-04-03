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
class RotateView : View {

    private val paint = Paint()
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(bitmap, 300f, 300f, paint)
        canvas.rotate(60f, 150f, 150f) // 顺时针倾斜
        canvas.drawBitmap(bitmap, 300f, 300f, paint)
    }
}