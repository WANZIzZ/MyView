package com.wanzi.myview.practicedraw2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 *     author : WZ
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/01
 *     desc   :
 *     version: 1.0
 */
class RadialGradientView : View {

    private val paint = Paint()

    private val clamp =
        RadialGradient(
            300f,
            300f,
            100f,
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.CLAMP
        )

    private val mirror =
        RadialGradient(
            600f,
            600f,
            100f,
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.MIRROR
        )
    private val repeat =
        RadialGradient(
            900f,
            900f,
            100f,
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.REPEAT
        )

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3

        paint.shader = clamp
        canvas?.drawCircle(300f, 300f, 200f, paint)

        paint.shader = mirror
        canvas?.drawCircle(600f, 600f, 200f, paint)

        paint.shader = repeat
        canvas?.drawCircle(900f, 900f, 200f, paint)
    }
}