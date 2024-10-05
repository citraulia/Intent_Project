package com.example.intentproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        val mReply = findViewById<EditText>(R.id.editText_second)
        val btnKirimSecond = findViewById<Button>(R.id.button_second)
        textView.text = message

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnKirimSecond.setOnClickListener(View.OnClickListener {
            val reply = mReply?.text.toString()
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY, reply)
            setResult(RESULT_OK, replyIntent)
            finish()
        })
    }
}