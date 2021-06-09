package com.example.authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val name = intent.getStringExtra("name")
        val nameText = findViewById<TextView>(R.id.nameView).apply{
            text = name
        }
    }
}