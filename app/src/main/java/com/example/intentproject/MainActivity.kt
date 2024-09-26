package com.example.intentproject

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private val LOG_TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mMessageEditText = findViewById<EditText>(R.id.editText_main)
        val btnKirim = findViewById<Button>(R.id.button_main)

        btnKirim.setOnClickListener(View.OnClickListener {
            Log.d(LOG_TAG, "Button clicked!")
            val intent = Intent(this, SecondActivity::class.java)
            val message = mMessageEditText.text.toString()
//            Log.d(LOG_TAG, message)
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun LaunchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
    }
}