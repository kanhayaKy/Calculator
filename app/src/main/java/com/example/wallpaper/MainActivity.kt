package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {


    private val images = listOf(R.drawable.image0,R.drawable.image1,R.drawable.image3,R.drawable.image3,R.drawable.image4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            changeBackground()
    }


    private fun changeBackground(){
        val changeButton = findViewById<Button>(R.id.changeButton)
        val background = findViewById<ImageView>(R.id.imageView)
        changeButton.setOnClickListener {

            val index = (0..4).random()
            print("----------------------------" + index)
            background.setImageResource(images[index])
        }
    }
}