package com.wanzi.myview.practicedraw4

import android.content.Context
import android.graphics.*
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
class CameraRotateView : View {

    private val paint = Paint()
    private val bitmap = getBitmap(R.drawable.maps)
    private val camera = Camera()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.save()

        // 原图
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        canvas.translate((width / 2).toFloat(), 0f)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
        canvas.save()

        // 绕X轴旋转
        canvas.translate(0f, (height / 4).toFloat())

        camera.save()
        camera.rotateX(30f)
        camera.applyToCanvas(canvas)
        camera.restore()

        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
        canvas.save()

        // 绕X轴旋转修复版
        canvas.translate((width / 2).toFloat(), (height / 4).toFloat())

        camera.save()
        camera.rotateX(30f)
        canvas.translate((bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat())
        camera.applyToCanvas(canvas)
        canvas.translate(-(bitmap.width / 2).toFloat(), -(bitmap.height / 2).toFloat())
        camera.restore()

        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
        canvas.save()

        // 绕Y轴旋转
        canvas.translate(0f, (height / 4 * 2).toFloat())

        camera.save()
        camera.rotateY(30f)
        camera.applyToCanvas(canvas)
        camera.restore()

        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
        canvas.save()

        // 绕Y轴旋转修复版
        canvas.translate((width / 2).toFloat(), (height / 4 * 2).toFloat())

        camera.save()
        camera.rotateY(30f)
        canvas.translate((bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat())
        camera.applyToCanvas(canvas)
        canvas.translate(-(bitmap.width / 2).toFloat(), -(bitmap.height / 2).toFloat())
        camera.restore()

        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
        canvas.save()

        // 绕Z轴旋转
        canvas.translate(0f, (height / 4 * 3).toFloat())

        camera.save()
        camera.rotateZ(30f)
        camera.applyToCanvas(canvas)
        camera.restore()

        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
        canvas.save()

        // 绕Y轴旋转修复版
        canvas.translate((width / 2).toFloat(), (height / 4 * 3).toFloat())

        camera.save()
        camera.rotateZ(30f)
        canvas.translate((bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat())
        camera.applyToCanvas(canvas)
        canvas.translate(-(bitmap.width / 2).toFloat(), -(bitmap.height / 2).toFloat())
        camera.restore()

        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.restore()
    }

    private fun getBitmap(id: Int): Bitmap {
        val option = BitmapFactory.Options()
        option.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, id, option)
        option.inSampleSize = 2
        option.inJustDecodeBounds = false
        return BitmapFactory.decodeResource(resources, id, option)
    }
}