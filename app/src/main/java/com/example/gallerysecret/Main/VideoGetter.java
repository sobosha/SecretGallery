package com.example.gallerysecret.Main;

import android.os.Handler;
import android.os.Looper;

import com.example.gallerysecret.Main.DataBase.ImageDao;
import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.DataBase.VideoDao;
import com.example.gallerysecret.Main.DataBase.VideoEntity;

import java.util.ArrayList;
import java.util.List;

public class VideoGetter implements Runnable {
    VideoDao videoDao;
    List<VideoEntity> videos;
    private IUpdateUiVideo iUpdateUi;
    private Handler handler=new Handler(Looper.getMainLooper());
    public VideoGetter(VideoDao videoDao , IUpdateUiVideo iUpdateUi) {
        this.videoDao=videoDao;
        videos=new ArrayList<>();
        this.iUpdateUi=iUpdateUi;
    }

    @Override
    public void run() {
        videos=videoDao.getAll();
        handler.post(()->{
            iUpdateUi.update(videos);
        });
    }

    public List<VideoEntity> getVideos() {
        return videos;
    }
}
