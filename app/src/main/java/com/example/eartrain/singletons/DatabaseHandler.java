package com.example.eartrain.singletons;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.eartrain.database.AppDatabase;

public class DatabaseHandler
{
    private Context context;
    private static DatabaseHandler instance;

    private AppDatabase appDatabase;

    private DatabaseHandler(Context context) {
        this.context = context;

        appDatabase = Room.databaseBuilder(context, AppDatabase.class,"EarTrainDB").build();
    }

    public static synchronized DatabaseHandler getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHandler(context);
        }
        return instance;
    }


    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
