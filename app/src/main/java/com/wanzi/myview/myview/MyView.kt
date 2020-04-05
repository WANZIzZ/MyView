package com.wanzi.myview.myview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/02
 *     desc   :
 *     version: 1.0
 */
class MyView : View {


    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        val region = Region(10, 10, 200, 100)
        region.union(Rect(10, 10, 50, 300))
        drawRegion(canvas, region, paint)
    }

    private fun drawRegion(canvas: Canvas, region: Region, paint: Paint) {
        val iter = RegionIterator(region)
        val r = Rect()
        while (iter.next(r)) {
            canvas.drawRect(r, paint)
        }
    }
}