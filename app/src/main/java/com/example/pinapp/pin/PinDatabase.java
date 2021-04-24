package com.example.pinapp.pin;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pin.class}, version = 1)
public abstract class PinDatabase extends RoomDatabase {
    public abstract PinDao pinDao();
}
