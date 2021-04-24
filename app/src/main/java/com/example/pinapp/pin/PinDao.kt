package com.example.pinapp.pin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PinDao {
    @Insert
    suspend fun insert(pin: Pin)

    @Delete
    suspend fun delete(pin: Pin)

    @Query("SELECT * FROM pin")
    suspend fun getAllPosts(): List<Pin>
}
