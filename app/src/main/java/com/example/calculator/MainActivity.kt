package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListeners()
    }

    private var  operator = ""
    @SuppressLint("WrongViewCast")
    private fun action(view: View) {
        val outputButton = findViewById<TextView>(R.id.box_display_text)
        val outputButton2 = findViewById<TextView>(R.id.output_box)
        var value = view.getTag()
            when(view.id){
                R.id.addButton, R.id.minusButton, R.id.multiplyButton, R.id.divideButton, R.id.percentageButton -> {
                    operator = value.toString()
                    val res = outputButton.text.toString() + operator
                    outputButton.setText(res)
                }
                R.id.clearButton -> {
                    outputButton.setText("")
                    outputButton2.setText("")
                }
                R.id.closeButton -> outputButton.setText(outputButton.text.drop(1))
                R.id.equalsButton -> {
                    val arr = outputButton.text.toString().split(operator)
                    val a = arr[0].toString().toInt()
                    val b = arr[1].toString().toInt()
                    Log.d("Main", arr[0].toString())


                    val res = when(operator){
                        "+" -> a + b
                        "%" -> a % b
                        "-" -> a - b
                        "*" -> a * b
                        "/" -> a / b
                        else -> "Invalid"
                    }
                    outputButton2.setText(outputButton.text)
                    outputButton.setText(res.toString())
                }

                else -> {
                    val res = outputButton.text.toString() + view.getTag().toString()
                    outputButton.setText(res)
                }
            }
    }

    private fun addListeners() {
        val addButton = findViewById<Button>(R.id.addButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val percentageButton = findViewById<Button>(R.id.percentageButton)
        val equalsButton = findViewById<Button>(R.id.equalsButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val closeButton = findViewById<Button>(R.id.closeButton)
        val oneButton = findViewById<Button>(R.id.oneButton)
        val twoButton = findViewById<Button>(R.id.twoButton)
        val threeButton = findViewById<Button>(R.id.threeButton)
        val fourButton = findViewById<Button>(R.id.fourButton)
        val fiveButton = findViewById<Button>(R.id.fiveButton)
        val sixButton = findViewById<Button>(R.id.sixButton)
        val sevenButton = findViewById<Button>(R.id.sevenButton)
        val eightButton = findViewById<Button>(R.id.eightButton)
        val nineButton = findViewById<Button>(R.id.nineButton)
        val buttonZero = findViewById<Button>(R.id.buttonZero)

        val clickableViews: List<View> =
            listOf(
                addButton,
                minusButton,
                multiplyButton,
                divideButton,
                percentageButton,
                equalsButton,
                clearButton,
                closeButton,
                oneButton,
                twoButton,
                threeButton,
                fourButton,
                fiveButton,
                sixButton,
                sevenButton,
                eightButton,
                nineButton,
                buttonZero
            )

        for (item in clickableViews) {
            item.setOnClickListener { action(it) }
        }
    }
}