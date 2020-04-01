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
class ComposeShaderView : View {

    private val paint = Paint()
    private val bitmap1 = BitmapShader(
        BitmapFactory.decodeResource(resources, R.drawable.batman),
        Shader.TileMode.CLAMP,
        Shader.TileMode.CLAMP
    )
    private val bitmap2 = BitmapShader(
        BitmapFactory.decodeResource(resources, R.drawable.batman_logo),
        Shader.TileMode.CLAMP,
        Shader.TileMode.CLAMP
    )

    private val shader = ComposeShader(bitmap1, bitmap2, PorterDuff.Mode.DST_IN)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = shader
        canvas?.drawCircle(500f, 500f, 500f, paint)
    }
}