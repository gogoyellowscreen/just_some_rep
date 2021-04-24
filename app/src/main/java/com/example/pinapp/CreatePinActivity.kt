package com.example.pinapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.pinapp.pin.Pin
import kotlinx.android.synthetic.main.activity_create_password.*
import kotlinx.coroutines.launch

class CreatePinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)

        createPinButton.setOnClickListener {
            // TODO: start ConfirmPinActivity with remained
            val pin = editCreatePin.text.toString().toIntOrNull()
            if (pin == null) {
                PinApp.instance.showToast(
                    "Your pin must contain only numbers and be non-empty", this)
            } else {
                val intent = Intent(this@CreatePinActivity, ConfirmPinActivity::class.java)
                intent.putExtra(PinApp.PIN_KEY, pin)
                startActivity(intent)
            }
        }
    }
}