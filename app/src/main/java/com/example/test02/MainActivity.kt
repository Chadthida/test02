package com.example.test02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val QuizApp: Button = findViewById(R.id.QuizApp)
        val CalculatorV2: Button = findViewById(R.id.CalculatorV2)
        val Login: Button = findViewById(R.id.Login)

        QuizApp.setOnClickListener {
            startActivity(Intent(this, P1::class.java))
            finish()
        }
        CalculatorV2.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
        Login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}