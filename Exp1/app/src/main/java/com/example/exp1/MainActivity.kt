package com.example.exp1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var changeFontButton: Button
    private lateinit var changeColorButton: Button
    private lateinit var changeBgButton: Button
    private lateinit var layout: ConstraintLayout

    private val fontSizes = floatArrayOf(16f, 20f, 24f, 30f)
    private var currentFontIndex = 0

    private val colors = arrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA)
    private var currentColorIndex = 0

    private val bgColors = arrayOf(Color.WHITE, Color.LTGRAY, Color.YELLOW, Color.CYAN)
    private var currentBgIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        textView = findViewById(R.id.textView)
        changeFontButton = findViewById(R.id.button)
        changeColorButton = findViewById(R.id.button2)
        changeBgButton = findViewById(R.id.button3)
        layout = findViewById(R.id.main)

        // Change Font Size Button
        changeFontButton.setOnClickListener {
            currentFontIndex = (currentFontIndex + 1) % fontSizes.size
            textView.textSize = fontSizes[currentFontIndex]
            Toast.makeText(this, "Font size changed", Toast.LENGTH_SHORT).show()
        }

        // Change Font Color Button
        changeColorButton.setOnClickListener {
            currentColorIndex = (currentColorIndex + 1) % colors.size
            textView.setTextColor(colors[currentColorIndex])
            Toast.makeText(this, "Font color changed", Toast.LENGTH_SHORT).show()
        }

        // Change Background Color Button
        changeBgButton.setOnClickListener {
            currentBgIndex = (currentBgIndex + 1) % bgColors.size
            layout.setBackgroundColor(bgColors[currentBgIndex])
            Toast.makeText(this, "Background color changed", Toast.LENGTH_SHORT).show()
        }
    }
}
