package com.wanzi.myview.practicedraw5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

/**
 *     author : 丸子
 *     e-mail : 1253437499@qq.com
 *     time   : 2020/04/06
 *     desc   :
 *     version: 1.0
 */
class BeforeDrawView : AppCompatEditText {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun draw(canvas: Canvas) {

        canvas.drawColor(Color.GREEN)

        super.draw(canvas)
    }
}