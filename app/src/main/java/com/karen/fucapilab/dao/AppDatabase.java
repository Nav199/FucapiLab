package com.karen.fucapilab.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.karen.fucapilab.model.Reserva;

@Database(entities = {Reserva.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public abstract ReservaDAO reservaDao();

    private static AppDatabase INSTANCE;

    public synchronized static AppDatabase getDbInstance(Context context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Fucapi_db")
                        .allowMainThreadQueries()
                        .build();
            }
        return INSTANCE;
    }
}