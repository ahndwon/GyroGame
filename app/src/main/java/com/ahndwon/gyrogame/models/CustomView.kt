package com.ahndwon.gyrogame.models

import android.content.Context
import android.graphics.*
import android.view.View
import android.view.MotionEvent
import android.view.WindowManager
import java.util.*
import kotlin.math.PI


class CustomView(context: Context) : View(context) {
    var tick: Int = 0
    val missileList = ArrayList<Missile>()
    val colors = intArrayOf(Color.RED, Color.GREEN, Color.BLUE)
    val random = Random()
    private var mBitmap: Bitmap? = null
    private var mCanvas: Canvas? = null
    var mPath: Path
    var mPaint: Paint
    var displaySize: Point
    private var mX: Float = 0.toFloat()
    private var mY: Float = 0.toFloat()
    private val TOLERANCE = 5f
    val gyro = Gyro(context)

    init {
        mPath = Path()

        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.FILL
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeWidth = 4f

        val display =
                (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        displaySize = Point()
        display.getSize(displaySize)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        mCanvas = Canvas(mBitmap)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        tick++
        if (tick > 30) {
            tick = 0
            val missile = Missile(context,
                    (random.nextInt(20) + 10).toFloat(),
                    colors[random.nextInt(colors.size)])
            missileList.add(missile)
            if(missileList.size > 30) missileList.removeAt(0)
        }
        gyro.render(canvas)
        for(m in missileList) {
            m.render(canvas)
        }
        println("list size : ${missileList.size}")
        invalidate()
    }

    private fun startTouch(x: Float, y: Float) {
        mX = x
        mY = y
    }

    private fun moveTouch(x: Float, y: Float) {
        val dx = mX - x
        val dy = y - mY

        // arctan2로 바꾸기
        if (Math.abs(dx) >= TOLERANCE || Math.abs(dy) >= TOLERANCE) {
            if (Math.abs(dx) > Math.abs(dy)) gyro.setPiesAngle(dx)
            else gyro .setPiesAngle(dy)
            mX = x
            mY = y
        }
    }

    fun clearCanvas() {
//        mPath.reset( )
        invalidate()
    }

    private fun upTouch() {
//        mPath.lineTo(mX, mY)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startTouch(x, y)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                moveTouch(x, y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                upTouch()
                invalidate()
            }
        }
        return true
    }


}