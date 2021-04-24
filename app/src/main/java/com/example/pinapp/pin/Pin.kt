package com.example.pinapp.pin

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
data class Pin (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "pin") val pin: Int
    )
