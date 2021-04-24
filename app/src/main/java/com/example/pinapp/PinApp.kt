package com.example.pinapp

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.room.Room
import com.example.pinapp.pin.PinDatabase

class PinApp : Application() {
    lateinit var db: PinDatabase

    override fun onCreate() {
        super.onCreate()

        instance = this

        db = Room
            .databaseBuilder(applicationContext, PinDatabase::class.java, "pin-database")
            .build()
    }

    suspend fun clearDb() {
        val allPins = db.pinDao().getAllPosts()
        for (pin in allPins) db.pinDao().delete(pin)
    }

    fun showToast(msg: String, context: Context) {
        Toast.makeText(
            context,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        lateinit var instance: PinApp
            private set

        const val PIN_KEY = "pin_key"
    }
}
