package com.ahndwon.gyrogame

import android.content.Context
import android.graphics.Point
import android.view.MotionEvent
import android.view.WindowManager
import com.ahndwon.gyrogame.models.Gyro
import processing.core.PApplet
import processing.event.TouchEvent

class Processing(val appContext: Context) : PApplet() {
    lateinit var gyro: Gyro
    lateinit var touch: TouchEvent.Pointer
    lateinit var dTouch: TouchEvent.Pointer

    internal fun main(passedArgs: Array<String>) {
        val appletArgs = arrayOf("Processing")
        if (passedArgs != null) {
            PApplet.main(PApplet.concat(appletArgs, passedArgs))
        } else {
            PApplet.main(appletArgs)
        }
    }

    override fun setup() {
        gyro = Gyro(appContext)
        background(255)
    }

    override fun settings() {
        fullScreen()
    }

    override fun draw() {
        gyro.update()
        gyro.render(this)
    }

    override fun touchStarted(event: TouchEvent) {
        dTouch = event.Pointer()
    }

    override fun touchMoved(event: TouchEvent) {
        touch = event.Pointer()
        val deltaX = dTouch.x - touch.x
        val deltaY = dTouch.y - touch.y

        var sign = 0

        if (Math.abs(deltaX) > Math.abs(deltaY)) sign = 1
        else sign = -1

        val difference = Math.sqrt(Math.pow(deltaX.toDouble(),
                2.toDouble()) + Math.pow(deltaY.toDouble(), 2.toDouble()))
        println("difference : $difference" +
                "")
//        gyro.setPiesAngle(radians(difference.toFloat()) * sign)
        gyro.setPiesAngle(radians(10f))
    }

    override fun touchEnded(event: TouchEvent) {
        println("touchEnded")
    }
}