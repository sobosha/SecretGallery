package com.example.gallerysecret.Main;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.gallerysecret.Main.DataBase.AppDatabaseImage;
import com.example.gallerysecret.Main.DataBase.ImageDao;
import com.example.gallerysecret.Main.DataBase.ImageEntity;

public class ImageSaver implements Runnable {
    ImageEntity imageEntity;
    AppDatabaseImage appDatabaseImage;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    ImageDao imageDao;
    Context context;
    public ImageSaver(Context context, AppDatabaseImage appDb, ImageDao imageDao, ImageEntity image){
        this.context=context;
        appDatabaseImage=appDb;
        this.imageDao=imageDao;
        imageEntity=image;
    }

    @Override
    public void run() {
        imageDao.insertAll(imageEntity);
    }
}
