package com.example.dialer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addListeners()
    }


    private fun inputAction(button : Button){
        val displayArea: TextView = findViewById<TextView>(R.id.displayBox)
        val delButton = findViewById<Button>(R.id.backspace)

        val value = button.text.toString()
        if(displayArea.text.length==5)
            displayArea.append(" ")
        displayArea.append(value)
        if (displayArea.text.isNotBlank() and (delButton.visibility == View.INVISIBLE)){
            delButton.visibility = View.VISIBLE
        }
    }

    private fun insertContact(phone: String) {
        println("===============================================================")
        println(phone)
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.PHONE, phone.replace("\\s".toRegex(),""))
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


    private fun removeAction(){
        val displayArea: TextView = findViewById<TextView>(R.id.displayBox)
        val delButton = findViewById<Button>(R.id.backspace)
        val text = displayArea.text.toString()
        displayArea.text = text.subSequence(0,text.length-1)
        if (displayArea.text.isEmpty()){
            delButton.visibility = View.INVISIBLE
        }
    }

    private fun startCall(){
        val contact = findViewById<TextView>(R.id.displayBox).text

        var phoneNumber = contact.replace("\\s".toRegex(), "")
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CALL_PHONE ), 1)
        }
        else{
            startCall()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==1) startCall()
    }

    private fun addListeners() {
        val oneButton = findViewById<Button>(R.id.oneButton)
        val twoButton = findViewById<Button>(R.id.twoButton)
        val threeButton = findViewById<Button>(R.id.threeButton)
        val fourButton = findViewById<Button>(R.id.fourButton)
        val fiveButton = findViewById<Button>(R.id.fiveButton)
        val sixButton = findViewById<Button>(R.id.sixButton)
        val sevenButton = findViewById<Button>(R.id.sevenButton)
        val eightButton = findViewById<Button>(R.id.eightButton)
        val nineButton = findViewById<Button>(R.id.nineButton)
        val zeroButton = findViewById<Button>(R.id.zeroButton)
        val starButton = findViewById<Button>(R.id.starButton)
        val hashButton = findViewById<Button>(R.id.hashButton)
        val delButton = findViewById<Button>(R.id.backspace)
        val saveButton = findViewById<Button>(R.id.buttonSave)
        val callButton = findViewById<Button>(R.id.buttonCall)
        val contact = findViewById<TextView>(R.id.displayBox).text

        saveButton.setOnClickListener{insertContact(contact.toString())}
        callButton.setOnClickListener{checkPermission()}
        delButton.setOnClickListener{removeAction()}
        delButton.visibility = View.INVISIBLE


        val clickableViews: List<View> =
            listOf(
                oneButton,
                twoButton,
                threeButton,
                fourButton,
                fiveButton,
                sixButton,
                sevenButton,
                eightButton,
                nineButton,
                zeroButton,
                starButton,
                hashButton
            )

        for (item in clickableViews) {
            item.setOnClickListener { inputAction(it as Button) }
        }
    }
}

