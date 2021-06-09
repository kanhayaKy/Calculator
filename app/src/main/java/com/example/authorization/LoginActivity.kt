package com.example.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addListeners()
    }

    private var count = 2

    private  fun login(){
        val name = intent.getStringExtra("name")
        val password = intent.getStringExtra("password")
        val nameText = findViewById<EditText>(R.id.Name).text.toString()
        val passwordText = findViewById<EditText>(R.id.password).text.toString()

        if(name == nameText && password == passwordText && count>0){
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("name",name)
            }
            startActivity(intent)
        }
        else{
            count = if(count>0) count-1 else 0
            Toast.makeText(this, "Invalid name or password. $count attempt left", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addListeners(){
        val submit = findViewById<Button>(R.id.login)
        submit.setOnClickListener { login() }
    }
}