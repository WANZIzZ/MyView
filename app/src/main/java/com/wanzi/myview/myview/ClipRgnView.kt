package com.wanzi.myview.myview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.wanzi.myview.R

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/04
 *     desc   :
 *     version: 1.0
 */
class ClipRgnView : View {

    private val paint = Paint()
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.a)
    private val path = Path()

    /**
     * 每行高度
     */
    private val CLIP_HEIGHT = 30f

    /**
     * 宽度
     */
    private var clipWidth = 0f

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        path.reset()

        var i = 0

        while (i * CLIP_HEIGHT <= height) {
            if (i % 2 == 0) {
                path.addRect(
                    0f,
                    i * CLIP_HEIGHT,
                    clipWidth,
                    CLIP_HEIGHT * (i + 1),
                    Path.Direction.CCW
                )
            } else {
                path.addRect(
                    width - clipWidth,
                    i * CLIP_HEIGHT,
                    width.toFloat(),
                    CLIP_HEIGHT * (i + 1),
                    Path.Direction.CCW
                )
            }
            i++
        }


        canvas.clipPath(path)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        if (clipWidth >= width) {
            return
        }

        clipWidth += 5

        invalidate()
    }
}