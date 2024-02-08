package com.example.test02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class lastpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lastpage)

        var number = intent
        var score = intent.getIntExtra("rand", 0)

        val num: TextView = findViewById(R.id.num)

        num.text = "$score"
    }
}