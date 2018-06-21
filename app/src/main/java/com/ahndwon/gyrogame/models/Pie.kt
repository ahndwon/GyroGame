package com.ahndwon.gyrogame.models

import android.content.Context
import android.graphics.*
import android.view.WindowManager
import kotlin.math.PI

class Pie(context: Context, val color: Int, var startAngle: Float){
    var endAngle : Float
    var mPath : Path
    var mPaint : Paint
    val displaySize: Point
    var radius = 300f

    init {
        endAngle = (startAngle + PI * 2 / 3).toFloat()
        mPath = Path()
        mPaint = Paint()
        mPaint.color = color
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeWidth = 4f

        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        displaySize = Point()
        display.getSize(displaySize)
    }

    fun render(canvas: Canvas) {
        canvas.drawArc((displaySize.x / 2 - radius),
                (displaySize.y / 2 - radius),
                (displaySize.x / 2 + radius),
                (displaySize.y / 2 + radius),
                startAngle,
                120f,
                true,
                mPaint)
    }
}