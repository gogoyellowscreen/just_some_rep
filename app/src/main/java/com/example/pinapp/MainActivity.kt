package com.example.pinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        createNewPinButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CreatePinActivity::class.java)
            startActivity(intent)
        }
    }
}