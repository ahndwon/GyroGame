package com.ahndwon.gyrogame.models

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.view.View
import android.view.WindowManager
import com.ahndwon.gyrogame.utils.Constants


open class Gyro(context: Context) : View(context), Constants {
    private val redPie : Pie
    private val greenPie : Pie
    private val bluePie : Pie


    init {
        val display =
                (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val displaySize = Point()
        display.getSize(displaySize)

        redPie = Pie(context, Color.RED, 0f)
        greenPie = Pie(context, Color.GREEN, 120f)
        bluePie = Pie(context, Color.BLUE, 240f)
    }

    fun render(canvas: Canvas) {
        redPie.render(canvas)
        greenPie.render(canvas)
        bluePie.render(canvas)
    }

    fun onUpdate() {

    }

    fun setPiesAngle(angle: Float) {
        redPie.startAngle += angle
        greenPie.startAngle += angle
        bluePie.startAngle += angle
    }
}