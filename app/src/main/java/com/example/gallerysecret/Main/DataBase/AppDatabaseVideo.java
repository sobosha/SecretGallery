package com.example.gallerysecret.Main.DataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {VideoEntity.class}, version = 1)
public abstract class AppDatabaseVideo extends RoomDatabase {
    public abstract VideoDao videoDao();

    private static AppDatabaseVideo instance;
    public static AppDatabaseVideo getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, AppDatabaseVideo.class, "video").build();

        return instance ;
    }
}
