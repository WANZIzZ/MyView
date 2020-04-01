package com.wanzi.myview.practicedraw2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanzi.myview.R

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/01
 *     desc   :
 *     version: 1.0
 */
class ColorMatrixColorFilterView : View {

    private val paint = Paint()
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val colorFilter = ColorMatrixColorFilter(ColorMatrix().apply {
        setSaturation(0f)
    })

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.colorFilter = colorFilter
        canvas?.drawBitmap(bitmap, 0f, 0f, paint)
    }
}