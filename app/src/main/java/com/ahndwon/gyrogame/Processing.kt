package com.ahndwon.gyrogame

import android.content.Context
import com.ahndwon.gyrogame.models.Gyro
import processing.core.PApplet

class Processing(val appContext: Context) : PApplet() {
    lateinit var gyro : Gyro

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
        gyro.render(this)
    }
}