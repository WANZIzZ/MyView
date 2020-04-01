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
class BitmapShaderView : View {

    private val paint = Paint()
    private val shader = BitmapShader(
        BitmapFactory.decodeResource(resources, R.drawable.batman),
        Shader.TileMode.CLAMP,
        Shader.TileMode.CLAMP
    )

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
        paint.shader = shader
        canvas?.drawCircle(500f, 500f, 500f, paint)
    }
}