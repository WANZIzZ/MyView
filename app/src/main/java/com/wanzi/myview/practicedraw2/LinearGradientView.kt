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
class LinearGradientView : View {

    private val paint = Paint()

    private val clamp = LinearGradient(
        100f,
        100f,
        300f,
        300f,
        Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"),
        Shader.TileMode.CLAMP
    )

    private val mirror = LinearGradient(
        100f,
        600f,
        300f,
        800f,
        Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"),
        Shader.TileMode.MIRROR
    )

    private val repeat = LinearGradient(
        100f,
        900f,
        300f,
        1100f,
        Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"),
        Shader.TileMode.REPEAT
    )

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3

        // 这里我并没有按照作业来做，主要是为了区分这三种模式的不同

        // 在端点之外延续端点处的颜色
        paint.shader = clamp
        canvas?.drawRect(100f, 100f, 500f, 500f, paint)

        // 镜像
        paint.shader = mirror
        canvas?.drawRect(100f, 600f, 500f, 1000f, paint)

        // 重复
        paint.shader = repeat
        canvas?.drawRect(100f, 1100f, 500f, 1500f, paint)
    }
}