package com.example.exp3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private val paint = Paint().apply{
        color = Color.YELLOW
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private val textPaint = Paint().apply {
        color = Color.RED
        textSize = 50f
        textAlign = Paint.Align.CENTER
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.YELLOW)

        paint.color = Color.RED
        canvas.drawText("Circle", 200f, 100f, textPaint)
        canvas.drawCircle(200f, 300f, 150f, paint)

        paint.color  = Color.GREEN
        textPaint.color = Color.GREEN
        canvas.drawText("Rectangle", 500f, 100f, textPaint)
        canvas.drawRect(400f, 160f, 600f, 600f, paint)

        paint.color = Color.BLUE
        textPaint.color = Color.BLUE
        canvas.drawText("Square", 200f, 700f, textPaint)
        canvas.drawRect(100f, 800f, 300f, 1000f, paint)

        paint.color = Color.BLACK
        textPaint.color = Color.BLACK
        canvas.drawText("Line", 500f, 700f, textPaint)
        canvas.drawLine(500f, 800f, 500f, 1000f, paint)
    }
}