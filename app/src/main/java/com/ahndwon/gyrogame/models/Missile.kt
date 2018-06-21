package com.ahndwon.gyrogame.models

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.view.View
import android.view.WindowManager
import com.ahndwon.gyrogame.utils.Constants
import java.util.*

class Missile(context: Context, val radius : Float, val color: Int) : View(context), Constants {
    val direction = intArrayOf(0, 1, 2, 3)
    val fillPaint: Paint
    val strokePaint: Paint
    val random = Random()
    lateinit var pos: Point
    val displaySize: Point


    init {
        fillPaint = Paint()
        fillPaint.color = color
        fillPaint.isAntiAlias = true
        fillPaint.style = Paint.Style.FILL
        fillPaint.strokeJoin = Paint.Join.ROUND
        fillPaint.strokeWidth = 4f

        strokePaint = Paint()
        strokePaint.color = Color.BLACK
        strokePaint.isAntiAlias = true
        strokePaint.style = Paint.Style.STROKE
        strokePaint.strokeJoin = Paint.Join.ROUND
        strokePaint.strokeWidth = 4f

        val display =
                (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        displaySize = Point()
        display.getSize(displaySize)
        randomPos()
    }

    fun randomPos() {
        val index = random.nextInt(direction.size)
        val randomX = random.nextInt(displaySize.x)
        val randomY = random.nextInt(displaySize.y)
//        pos = Point(randomX, randomY)
        when(index) {
            0 -> pos = Point(0, randomY)
            1 -> pos = Point( randomX, 0)
            2 -> pos = Point( displaySize.x, randomX)
            3 -> pos = Point( randomX, displaySize.y)
        }
    }

    fun render(canvas: Canvas) {
        move()
        canvas.drawCircle(pos.x.toFloat(), pos.y.toFloat(), radius, fillPaint)
        canvas.drawCircle(pos.x.toFloat(), pos.y.toFloat(), radius, strokePaint)
//        canvas.drawCircle(random.nextInt(displaySize.x).toFloat(),
//                random.nextInt(displaySize.y).toFloat(),
//                radius, fillPaint)
    }

    fun move() {
        pos.x += (displaySize.x / 2 - pos.x) / 30
        pos.y += (displaySize.y / 2 - pos.y) / 30
    }

}