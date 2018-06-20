package com.ahndwon.gyrogame.models

import models.Vector2D
import processing.core.PApplet


abstract class View : Cloneable {
    lateinit var pos: Vector2D
    lateinit var size: Vector2D

    internal interface OnClickListener {
        fun onClick(view: View)
    }

    abstract fun render(pApplet: PApplet)
    abstract fun onUpdate()

    fun update() {
        onUpdate()
    }
}
