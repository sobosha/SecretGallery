package com.example.gallerysecret.Main;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.gallerysecret.Main.DataBase.AppDatabaseImage;
import com.example.gallerysecret.Main.DataBase.AppDatabaseVideo;
import com.example.gallerysecret.Main.DataBase.ImageDao;
import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.DataBase.VideoDao;
import com.example.gallerysecret.Main.DataBase.VideoEntity;

public class VideoSaver implements Runnable {
    VideoEntity videoEntity;
    AppDatabaseVideo appDatabaseVideo;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    VideoDao videoDao;
    Context context;
    public VideoSaver(Context context, AppDatabaseVideo appDb, VideoDao videoDao, VideoEntity video){
        this.context=context;
        appDatabaseVideo=appDb;
        this.videoDao=videoDao;
        videoEntity=video;
    }

    @Override
    public void run() {
        videoDao.insertAll(videoEntity);
    }
}
