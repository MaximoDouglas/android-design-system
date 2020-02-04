package com.example.draw_on_screen

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ImageView
import android.graphics.Path
import android.util.Log
import androidx.core.content.ContextCompat

class CustomDrawView(context: Context, attrs: AttributeSet? = null): ImageView(context, attrs) {

    private val STATE_STILL                                   = 0
    private val STATE_MOVING                                  = 1
    private var DEFAULT_COLOR                                 = 0
    private var state                                         = 0
    private var latestPath: Path?                             = null
    private var latestPaint: Paint?                           = null
    private var callbackForCoordinate: GetCoordinateCallback? = null
    private var lineWidth                                     = 15
    private var currentColor: Int                             = 0

    private val paintPenList= mutableListOf<Paint>()
    private val pathPenList = mutableListOf<Path>()

    private fun init() {

        DEFAULT_COLOR = ContextCompat.getColor(context, R.color.colorPrimary)
        currentColor = DEFAULT_COLOR

        initPaintNPen(currentColor)

    }

    private fun initPaintNPen(color: Int) {
        latestPaint = getNewPaintPen(color)
        latestPath  = getNewPathPen()

        latestPaint?.let { paintPenList.add(it) }
        latestPath?.let { pathPenList.add(it) }
    }

    private fun getNewPathPen(): Path {
        return Path()
    }

    private fun getNewPaintPen(color: Int): Paint {
        val mPaintPen = Paint()

        mPaintPen.strokeWidth = lineWidth.toFloat()
        mPaintPen.isAntiAlias = true
        mPaintPen.isDither    = true
        mPaintPen.style       = Paint.Style.STROKE
        mPaintPen.strokeJoin  = Paint.Join.MITER
        mPaintPen.strokeCap   = Paint.Cap.ROUND
        mPaintPen.color       = color

        return mPaintPen
    }

    fun setThisCallback(callback: GetCoordinateCallback) {
        this.callbackForCoordinate = callback
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        Log.i("CO-ordinate", event.x.toString() + " : " + event.y)

        when {
            event.action == MotionEvent.ACTION_DOWN -> {
                callbackForCoordinate!!.start(x, y)
                startPath(x, y)
            }
            event.action == MotionEvent.ACTION_MOVE -> {
                callbackForCoordinate!!.moving(x, y)
                updatePath(x, y)
            }
            event.action == MotionEvent.ACTION_UP -> {
                callbackForCoordinate!!.end(x, y)
                endPath(x, y)
            }
        }
        invalidate()
        return true
    }

    private fun startPath(x: Float, y: Float) {
        initPaintNPen(currentColor)
        latestPath?.moveTo(x, y)
    }

    private fun updatePath(x: Float, y: Float) {
        state = STATE_MOVING

        latestPath?.lineTo(x, y)
    }

    private fun endPath(x: Float, y: Float) {

    }

    fun setDrawColor(color: Int) {

        currentColor = color

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (i in 0 until paintPenList.size) {
            canvas.drawPath(pathPenList[i], paintPenList[i])
        }
    }

    fun increaseWidth(decrease: Boolean) {

        if (decrease) {
            if (lineWidth > 5) {
                lineWidth -= 10
            }
        } else {
            if (lineWidth < 50) {
                lineWidth += 10
            }
        }

        invalidate()
    }

    fun resetView() {
        currentColor = DEFAULT_COLOR
        state        = STATE_STILL

        latestPath?.reset()
        latestPaint?.reset()

        pathPenList.clear()
        paintPenList.clear()

        lineWidth = 20

        initPaintNPen(currentColor)
        invalidate()
    }


    fun undoPath() {
        if (paintPenList.size > 1) {
            latestPaint = paintPenList.get(paintPenList.size - 2)
            latestPath  = pathPenList.get(pathPenList.size - 2)

            paintPenList.removeAt(paintPenList.size - 1)
            pathPenList.removeAt(pathPenList.size - 1)

            currentColor = latestPaint!!.color
            lineWidth    = latestPaint!!.strokeWidth.toInt()
        } else {
            resetView()
        }

        invalidate()
    }

    interface GetCoordinateCallback {
        fun moving(x: Float, y: Float)
        fun start(x: Float, y: Float)
        fun end(x: Float, y: Float)
    }


}