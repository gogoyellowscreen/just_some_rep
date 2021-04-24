package com.example.pinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.pinapp.pin.Pin
import kotlinx.android.synthetic.main.activity_confirm_password.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class ConfirmPinActivity : AppCompatActivity() {
    var pin: Int = Int.MIN_VALUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_password)

        if (intent?.extras?.containsKey(PinApp.PIN_KEY) == true) {
            pin = intent!!.extras!!.getInt(PinApp.PIN_KEY)
        }

        confirmPinButton.setOnClickListener {
            val enteredPin = editConfirmPin.text.toString().toIntOrNull()
            if (enteredPin == null || enteredPin != pin) {
                PinApp.instance.showToast("Pins are different", this)
            } else {
                lifecycleScope.launch {
                    PinApp.instance.clearDb()
                    PinApp.instance.db.pinDao().insert(Pin(Random.nextInt(), pin))
                    val intent = Intent(this@ConfirmPinActivity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        }
    }
}