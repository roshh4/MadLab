package com.example.exp2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class Exp2Activity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Number and Operator Buttons
        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnDot
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                val buttonText = (it as Button).text.toString()
                currentInput += buttonText
                display.text = currentInput
            }
        }

        // Equals Button
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            try {
                val result = ExpressionBuilder(currentInput).build().evaluate()
                display.text = result.toString()
                currentInput = result.toString() // Update for chaining calculations
            } catch (e: Exception) {
                display.text = "Error"
                currentInput = ""
            }
        }

        // Clear Button
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            display.text = "0"
        }
    }
}
