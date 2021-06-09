package com.example.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListeners()
    }

    private fun register(){
        val regex = ("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$").toRegex()
        val email = findViewById<EditText>(R.id.EmailAddress).text.toString()
        val name = findViewById<EditText>(R.id.Name).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        println(password +"==============="+password.matches(regex))
        if(password.matches(regex)){
            val intent = Intent(this, LoginActivity::class.java).apply {
                putExtra("name",name)
                putExtra("password",password)
            }
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Please ensure you're entering a valid password format", Toast.LENGTH_SHORT).show()
        }

    }

    private fun addListeners(){
        val submit = findViewById<Button>(R.id.login)
        submit.setOnClickListener { register() }
    }
}