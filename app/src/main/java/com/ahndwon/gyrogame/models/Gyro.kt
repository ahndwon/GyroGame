package com.ahndwon.gyrogame.models

import android.content.Context
import models.Vector2D
import processing.core.PApplet
import android.view.Display
import android.content.Context.WINDOW_SERVICE
import android.graphics.Point
import android.view.WindowManager
import com.ahndwon.gyrogame.utils.Constants
import processing.core.PConstants.CENTER


class Gyro(val context: Context) : View(), Constants {
    init {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val displaySize = Point()
        display.getSize(displaySize)
        pos = Vector2D(displaySize.x.toFloat() / 2, displaySize.y.toFloat() / 2)
        size = Vector2D(GYRO_SIZE.toFloat(), GYRO_SIZE.toFloat())
    }
    override fun render(pApplet: PApplet) {
        pApplet.fill(0)
        pApplet.ellipseMode(CENTER)
        pApplet.ellipse(pos.x, pos.y, size.x, size.y)
    }

    override fun onUpdate() {

    }

}