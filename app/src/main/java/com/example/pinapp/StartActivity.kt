package com.example.pinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val pinList = PinApp.instance.db.pinDao().getAllPosts()
            if (pinList.isEmpty()) {
                buttonPin.setOnClickListener {
                    val intent = Intent(this@StartActivity, CreatePinActivity::class.java)
                    startActivity(intent)
                }
                buttonPin.visibility = View.VISIBLE
            } else {
                val pin = pinList.first()
                editTextNumberPassword.visibility = View.VISIBLE
                checkPinButton.setOnClickListener {
                    val enteredPin: Int? = editTextNumberPassword.text.toString().toIntOrNull()
                    if (enteredPin == pin.pin) {
                        // TODO: start MainActivity
                        val intent = Intent(this@StartActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    } else {
                        PinApp.instance.showToast("Incorrect pin. Try again", this@StartActivity)
                    }
                }

                checkPinButton.visibility = View.VISIBLE
                enterPinText.visibility = View.VISIBLE
            }
        }
    }
}