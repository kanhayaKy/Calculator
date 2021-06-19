package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var mainHandler: Handler
    var count : Int = 0


    private val counter = object : Runnable {

        override fun run() {
            count+=1
            findViewById<TextView>(R.id.counterValue).text = count.toString()
            mainHandler.postDelayed(this, 1000)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainHandler = Handler(Looper.getMainLooper())
        addListener();
    }


    private fun stop(){
        count=0
        mainHandler.removeCallbacks(counter)
        findViewById<TextView>(R.id.counterValue).text = count.toString()
    }

    private fun addListener(){

        val start = findViewById<Button>(R.id.startButton)
        val stop = findViewById<Button>(R.id.stopButton)
        start.setOnClickListener{
            start.isEnabled = false
            mainHandler.post(counter)}
        stop.setOnClickListener{
            start.isEnabled = true
            stop()}
    }

}