package com.wanzi.myview.practicedraw4

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
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
class ClipPathView : View {

    private val paint = Paint()
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private val path = Path()
    private val path2 = Path()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()

        path.addCircle(300f + bitmap.width / 2, 300f + bitmap.height / 2, 200f, Path.Direction.CW)
        canvas.clipPath(path)
        canvas.drawBitmap(bitmap, 300f, 300f, paint)

        canvas.restore()

        paint.style = Paint.Style.STROKE
        canvas.drawPath(path, paint)
        canvas.drawRect(300f, 300f, 300f + bitmap.width, 300f + bitmap.height, paint)


        canvas.translate(0f, (height / 2).toFloat()) // 平移

        canvas.save()

        path2.addCircle(300f + bitmap.width / 2, 300f + bitmap.height / 2, 200f, Path.Direction.CW)
        path2.fillType = Path.FillType.INVERSE_WINDING  // 设置路径填充方式
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, 300f, 300f, paint)

        canvas.restore()

        paint.style = Paint.Style.STROKE
        canvas.drawPath(path2, paint)
        canvas.drawRect(300f, 300f, 300f + bitmap.width, 300f + bitmap.height, paint)
    }
}