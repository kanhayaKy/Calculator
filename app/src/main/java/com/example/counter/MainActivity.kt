package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val start = findViewById<Button>(R.id.startButton)
    private val stop = findViewById<Button>(R.id.stopButton)
    private val counter = findViewById<TextView>(R.id.counterValue)
    private lateinit var handler: Handler
    private lateinit var runnable:Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListeners()
    }

    private fun counter(button: Button){
        button.isEnabled = false
        when(button.id.toString()){
            "Start" -> {
                stop.isEnabled=true
            }
            "Stop" ->{
                start.isEnabled=true
            }
        }

    }

    private fun addListeners() {
        val clickableViews: List<View> = listOf(start, stop)
        for (item in clickableViews) {
            item.setOnClickListener { counter(it as Button) }
        }


    }

}