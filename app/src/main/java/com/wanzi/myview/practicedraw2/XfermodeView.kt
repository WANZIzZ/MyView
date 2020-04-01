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
class XfermodeView : View {

    private val paint = Paint()
    private val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    private val xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val saved = canvas.saveLayer(null, null)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        paint.xfermode = xfermode
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.xfermode = null

        canvas.restoreToCount(saved)
    }
}