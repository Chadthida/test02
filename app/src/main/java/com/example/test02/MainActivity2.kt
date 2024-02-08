package com.example.test02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

        private lateinit var textView: TextView
        private var currentInput: String = ""
        private var currentOperator: String? = ""
        private var firstOperand: Double? = 0.0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main2)

            textView = findViewById(R.id.Total)

            val numberButtons = arrayOf(
                R.id.N0,R.id.N1, R.id.N2, R.id.N3, R.id.N4,
                R.id.N5, R.id.N6, R.id.N7, R.id.N8,
                R.id.N9, R.id.Decimal
            )

            for (buttonId in numberButtons) {
                findViewById<Button>(buttonId).setOnClickListener {
                    onNumberButtonClick(it)
                }
            }

            findViewById<Button>(R.id.Del).setOnClickListener {
                onDeleteButtonClick()
            }

            findViewById<Button>(R.id.C).setOnClickListener {
                clearAll()
            }

            val operatorButtons = arrayOf(
                R.id.Plus, R.id.Minus, R.id.Multiplied,R.id.Divide, R.id.Modulo
            )

            for (buttonId in operatorButtons) {
                findViewById<Button>(buttonId).setOnClickListener {
                    onOperatorButtonClick(it)
                }
            }

            findViewById<Button>(R.id.Equals).setOnClickListener {
                onEqualsButtonClick()
            }

            Log.e("cs", "Result: $currentInput")
            Log.e("cc", "Result: $currentOperator")
            Log.e("we", "Result: $textView")
            Log.e("rd", "Result: $firstOperand")
        }

        private fun clearAll() {
            currentInput = "0"
            currentOperator = null
            firstOperand = null
            updateResult()
        }


        private fun onNumberButtonClick(view: View) {
            val buttonText = (view as Button).text.toString()

            if (currentInput == "0") {
                currentInput = buttonText
            } else {
                currentInput += buttonText
            }

            updateResult()
        }

        private fun onDeleteButtonClick() {
            if (currentInput.length > 1) {
                currentInput = currentInput.substring(0, currentInput.length - 1)
            } else {
                currentInput = "0"
            }

            updateResult()
        }

        private fun onOperatorButtonClick(view: View) {
            currentOperator = (view as Button).text.toString()
            firstOperand = currentInput.toDouble()
            currentInput = "0"
        }

        private fun onEqualsButtonClick() {
            if (currentOperator != null && firstOperand != null) {
                val secondOperand = currentInput.toDouble()
                val result = when (currentOperator) {
                    "+" -> firstOperand!! + secondOperand
                    "-" -> firstOperand!! - secondOperand
                    "x" -> firstOperand!! * secondOperand
                    "/" -> firstOperand!! / secondOperand
                    "%" -> firstOperand!! % secondOperand
                    else -> throw IllegalArgumentException("Invalid operator")
                }

                currentInput = result.toString()
                currentOperator = null
                firstOperand = null

                updateResult()
            }
        }

        private fun updateResult() {
            textView.text = currentInput
        }
    }