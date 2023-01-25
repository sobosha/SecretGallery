package com.example.gallerysecret.Main.DataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ImageEntity.class}, version = 1)
public abstract class AppDatabaseImage extends RoomDatabase {

    public abstract ImageDao imageDao();
    private static AppDatabaseImage instance;
    public static AppDatabaseImage getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, AppDatabaseImage.class, "image").build();
        return instance ;
    }
}
