package com.example.exp12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etmail: EditText = findViewById(R.id.etmail)
        val etsubject: EditText = findViewById(R.id.etsubject)
        val ettext: EditText = findViewById(R.id.ettext)
        val btsend: Button = findViewById(R.id.btsend)

        btsend.setOnClickListener {
            val email: String = etmail.text.toString()
            val subject: String = etsubject.text.toString()
            val text: String = ettext.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose an Email client :"))
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}