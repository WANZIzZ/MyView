package com.wanzi.myview.practicedraw2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanzi.myview.R

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/01
 *     desc   :
 *     version: 1.0
 */
class MaskFilterView : View {

    private val paint = Paint()
    private val path = Path()
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        paint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
        canvas?.drawBitmap(bitmap, 50f, 50f, paint)
    }
}