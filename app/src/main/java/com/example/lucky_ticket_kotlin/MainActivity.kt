package com.example.lucky_ticket_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity() {
    private val maxLength = 6
    private val number = findViewById<EditText>(R.id.number)
    private val bubble = findViewById<ImageView>(R.id.bubble)
    private val button = findViewById<Button>(R.id.button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { onClick() }
    }

    private fun onClick() {
        if (number.length() == maxLength) {
            try {
                val digits = number.text.toString()
                val sum_a = digits.substring(0, 3).toInt()
                val sum_b = digits.substring(3, 6).toInt()

                if (sum_a == sum_b) {
                    Toast.makeText(applicationContext, R.string.yes, Toast.LENGTH_LONG).show()
                    bubble.setImageResource(R.drawable.bubl_green)
                } else {
                    Toast.makeText(applicationContext, R.string.no, Toast.LENGTH_LONG).show()
                    bubble.setImageResource(R.drawable.bubl_red)
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, R.string.dig, Toast.LENGTH_LONG).show()
            }
        }

    }
}
