package com.ahndwon.gyrogame.models

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.view.View
import android.view.WindowManager
import com.ahndwon.gyrogame.utils.Constants
import java.util.*

class Missile(context: Context, val radius : Float, val color: Int) : View(context), Constants {
    val direction = intArrayOf(0, 1, 2, 3)
    val mPaint: Paint
    val random = Random()
    lateinit var pos: Point
    val displaySize: Point


    init {
        mPaint = Paint()
        mPaint.color = color
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeWidth = 4f

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
        when(index) {
            0 -> pos = Point(0, randomY)
            1 -> pos = Point( randomX, 0)
            2 -> pos = Point( displaySize.x, randomX)
            3 -> pos = Point( randomX, displaySize.y)
        }
    }

    fun render(canvas: Canvas) {
        move()
//        canvas.drawCircle(pos.x.toFloat(), pos.y.toFloat(), radius, mPaint)
        canvas.drawCircle(random.nextInt(displaySize.x).toFloat(),
                random.nextInt(displaySize.y).toFloat(),
                radius, mPaint)
    }

    fun move() {
        pos.x += (displaySize.x - pos.x) / 300
        pos.y += (displaySize.y - pos.y) / 300
    }

}