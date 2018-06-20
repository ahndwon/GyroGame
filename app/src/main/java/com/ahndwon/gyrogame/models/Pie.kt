package com.ahndwon.gyrogame.models

import android.content.Context
import models.Vector2D
import processing.core.PApplet
import kotlin.math.PI

class Pie(val color : RGBColor, var startAngle: Float,
          val pos: Vector2D, val size : Vector2D){
    var endAngle : Float
    init {
        println("init, color: ${color.r}, ${color.g}, ${color.b}")
        endAngle = (startAngle + PI * 2 / 3).toFloat()
    }

    fun render(pApplet: PApplet) {
        pApplet.fill(color.r, color.g, color.b, color.alpha)
        endAngle = (startAngle + PI * 2 / 3).toFloat()
        pApplet.arc(pos.x, pos.y, size.x, size.y, startAngle, endAngle)
    }
}