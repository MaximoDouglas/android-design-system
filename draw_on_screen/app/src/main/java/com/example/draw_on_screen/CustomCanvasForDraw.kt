package com.example.draw_on_screen

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View

class CustomCanvasForDraw(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RelativeLayout(context, attrs, defStyleAttr), CustomDrawView.GetCoordinateCallback {

    private var customDrawView: CustomDrawView? = null
    private var startText: TextView?            = null
    private var moveText: TextView?             = null
    private var endText: TextView?              = null
    private var isDebugEnabled: Boolean         = true

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.custom_canvas_for_draw, this, true)

        customDrawView = findViewById<CustomDrawView>(R.id.mainView)
        startText      = findViewById<TextView>(R.id.startPointText)
        moveText       = findViewById<TextView>(R.id.movingPointText)
        endText        = findViewById<TextView>(R.id.endPointText)

        if (isDebugEnabled) {
            startText?.visibility = View.VISIBLE
            moveText?.visibility  = View.VISIBLE
            endText?.visibility   = View.VISIBLE
        } else {
            startText?.visibility = View.GONE
            moveText?.visibility  = View.GONE
            endText?.visibility   = View.GONE
        }

        customDrawView?.setThisCallback(this)
    }

    fun setDebugMode(isDebugEnabled: Boolean) {
        this.isDebugEnabled = isDebugEnabled
    }

    fun changeColor(color: Int) {
        customDrawView?.setDrawColor(color)
    }

    fun undoView() {
        customDrawView?.undoPath()
    }

    fun increaseWidth(decrease: Boolean) {
        customDrawView?.increaseWidth(decrease)
    }

    fun resetView() {
        customDrawView?.resetView()
        moveText?.setText("0.0")
        startText?.setText("0.0")
        endText?.setText("0.0")
    }

    override fun moving(x: Float, y: Float) {
        val moveTextString = String.format("%.02f", x) + ", " + String.format("%.02f", y)
        moveText?.text = moveTextString
    }

    override fun start(x: Float, y: Float) {
        val startTextString = String.format("%.02f", x) + ", " + String.format("%.02f", y)
        startText?.text = startTextString
    }

    override fun end(x: Float, y: Float) {
        val endTextString = String.format("%.02f", x) + ", " + String.format("%.02f", y)
        endText?.text = endTextString
    }


}