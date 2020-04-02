package com.wanzi.myview.practicedraw3

import android.content.Context
import android.graphics.*
import android.text.StaticLayout
import android.text.TextPaint
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
class ShowTextView : View {

    private val paint = Paint()
    private val paint2 = Paint()
    private val paint3 = Paint()

    private val text1 = "Hello World"
    private val text2 = "Hello\nWorld"
    private val text3 = "Hello World !!!"
    private val text4 = "三个月内你胖了"
    private val text5 = "45"
    private val text6 = "公斤"

    private val text7 = "A"
    private val text8 = "a"
    private val text9 = "J"
    private val text10 = "j"
    private val text11 = "Â"
    private val text12 = "â"

    private val rect7 = Rect()
    private val rect8 = Rect()
    private val rect9 = Rect()
    private val rect10 = Rect()
    private val rect11 = Rect()
    private val rect12 = Rect()


    private val textPaint = TextPaint().apply {
        textSize = 50f
    }

    private val staticLayout1 =
        StaticLayout.Builder.obtain(text2, 0, text2.length, textPaint, 600).build()
    private val staticLayout2 =
        StaticLayout.Builder.obtain(text3, 0, text3.length, textPaint, 80).build()

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.reset()

        canvas.run {

            // 普通的文字绘制
            paint.textSize = 50f
            translate(50f, 50f)
            drawText(text1, 0f, 0f, paint)

            // 换行
            translate(0f, 30f)
            staticLayout1.draw(canvas)
            translate(500f, 0f)
            staticLayout2.draw(canvas)

            // 设置文字大小
            paint.textSize = 80f
            translate(-500f, 480f)
            drawText(text1, 0f, 0f, paint)

            paint.textSize = 50f

            // 设置文字字体
            paint.typeface = Typeface.SERIF
            translate(0f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.typeface = Typeface.createFromAsset(context.assets, "Satisfy-Regular.ttf")
            translate(500f, 0f)
            drawText(text1, 0f, 0f, paint)

            paint.typeface = null

            // 加粗文字
            paint.isFakeBoldText = true
            translate(-500f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.isFakeBoldText = false

            // 设置删除线
            paint.isStrikeThruText = true
            translate(0f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.isStrikeThruText = false

            // 设置下划线
            paint.isUnderlineText = true
            translate(500f, 0f)
            drawText(text1, 0f, 0f, paint)

            paint.isUnderlineText = false

            // 设置文字倾斜
            paint.textSkewX = -0.5f
            translate(-500f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.textSkewX = 0f

            // 设置文字宽度
            paint.textScaleX = 2f
            translate(0f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.textScaleX = 1f

            // 设置文字间距
            paint.letterSpacing = 1f
            translate(0f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.letterSpacing = 0f

            // 设置文字对齐方式
            paint.textAlign = Paint.Align.RIGHT
            translate(0f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.textAlign = Paint.Align.CENTER
            translate(0f, 80f)
            drawText(text1, 0f, 0f, paint)

            paint.textAlign = Paint.Align.LEFT
            translate(0f, 80f)
            drawText(text1, 0f, 0f, paint)

            // 获取推荐的行间距
            translate(0f, paint.fontSpacing)
            drawText(text1, 0f, 0f, paint)
            translate(0f, 20f)
            drawText(text1, 0f, 0f, paint)

            // 测量文字宽度
            translate(0f, paint.fontSpacing)
            drawText(text4, 0f, 0f, paint)
            paint2.textSize = 80f
            paint2.color = Color.RED
            drawText(text5, paint.measureText(text4), 0f, paint2)
            drawText(text6, paint.measureText(text4) + paint2.measureText(text5), 0f, paint)


            translate(0f, paint.fontSpacing)

            paint.style = Paint.Style.STROKE
            paint.color = Color.RED
            paint.strokeWidth = 20f
            drawRect(0f, 0f, 620f, 200f, paint)

            paint3.textSize = 160f

            // 使用 Paint.getTextBounds() 计算出文字的显示区域
            // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

            /*paint3.getTextBounds(text7, 0, text7.length, rect7)
            paint3.getTextBounds(text8, 0, text8.length, rect8)
            paint3.getTextBounds(text9, 0, text9.length, rect9)
            paint3.getTextBounds(text10, 0, text10.length, rect10)
            paint3.getTextBounds(text11, 0, text11.length, rect11)
            paint3.getTextBounds(text12, 0, text12.length, rect12)

            drawText(text7, 10f, (200f - (rect7.bottom + rect7.top)) / 2, paint3)
            drawText(text8, 110f, (200f - (rect8.bottom + rect8.top)) / 2, paint3)
            drawText(text9, 210f, (200f - (rect9.bottom + rect9.top)) / 2, paint3)
            drawText(text10, 310f, (200f - (rect10.bottom + rect10.top)) / 2, paint3)
            drawText(text11, 410f, (200f - (rect11.bottom + rect11.top)) / 2, paint3)
            drawText(text12, 510f, (200f - (rect12.bottom + rect12.top)) / 2, paint3)*/


            // 使用 Paint.getFontMetrics() 计算出文字的显示区域
            // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

            val fontMetrics = (paint3.fontMetrics.descent + paint3.fontMetrics.ascent)
            val y = (200f - fontMetrics) / 2

            drawText(text7, 10f, y, paint3)
            drawText(text8, 110f, y, paint3)
            drawText(text9, 210f, y, paint3)
            drawText(text10, 310f, y, paint3)
            drawText(text11, 410f, y, paint3)
            drawText(text12, 510f, y, paint3)

        }
    }

}