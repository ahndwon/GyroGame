package com.ahndwon.gyrogame.models

import android.content.Context
import models.Vector2D
import processing.core.PApplet
import android.graphics.Point
import android.view.WindowManager
import com.ahndwon.gyrogame.utils.Constants


open class Gyro(context: Context) : View(), Constants {
    private val redPie : Pie
    private val greenPie : Pie
    private val bluePie : Pie


    init {
        val display =
                (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val displaySize = Point()
        display.getSize(displaySize)
        pos = Vector2D(displaySize.x.toFloat() / 2, displaySize.y.toFloat() / 2)
        size = Vector2D(GYRO_SIZE.toFloat(), GYRO_SIZE.toFloat())

        redPie = Pie(RGBColor(255f,0f,0f,255f),
                PApplet.radians( 120f),pos, size)
        greenPie = Pie(RGBColor(0f,255f,0f,255f),
                PApplet.radians(240f), pos, size)
        bluePie = Pie(RGBColor(0f,0f,255f,255f),
                PApplet.radians(360f), pos, size)
    }

    override fun render(pApplet: PApplet) {
        redPie.render(pApplet)
        greenPie.render(pApplet)
        bluePie.render(pApplet)
    }

    override fun onUpdate() {
//        redPie.startAngle += angle
//        greenPie.startAngle += angle
//        bluePie.startAngle += angle
    }

    fun setPiesAngle(angle: Float) {
        redPie.startAngle += angle
        greenPie.startAngle += angle
        bluePie.startAngle += angle
    }
}