package com.example.test02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class P1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p1)

        var number: Int = 0

        val A: Button = findViewById(R.id.A)
        val B: Button = findViewById(R.id.B)
        val C: Button = findViewById(R.id.C)
        val D: Button = findViewById(R.id.D)

        A.setOnClickListener {
            val intent = Intent(this, P2::class.java)
            number += 1
            intent.putExtra("rand", number)
            startActivity(intent)
        }
        B.setOnClickListener {
            val intent = Intent(this, P2::class.java)
            startActivity(intent)
        }
        C.setOnClickListener {
            val intent = Intent(this, P2::class.java)
            startActivity(intent)
        }
        D.setOnClickListener {
            val intent = Intent(this, P2::class.java)
            startActivity(intent)
        }
    }
}