package com.example.gallerysecret.Main;

import android.os.Handler;
import android.os.Looper;

import com.example.gallerysecret.Main.DataBase.ImageDao;
import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.DataBase.VideoDao;
import com.example.gallerysecret.Main.DataBase.VideoEntity;

import java.util.ArrayList;
import java.util.List;

public class VideoRestore implements Runnable {
    VideoDao videoDao;
    List<VideoEntity> videos;
    VideoEntity video;
    private IUpdateUiVideo iUpdateUi;
    private Handler handler=new Handler(Looper.getMainLooper());
    public VideoRestore(VideoDao videoDao , VideoEntity video, IUpdateUiVideo iUpdateUi) {
        this.videoDao=videoDao;
        videos=new ArrayList<>();
        this.iUpdateUi=iUpdateUi;
        this.video=video;
    }

    @Override
    public void run() {
        videoDao.deleteById(video.getId());
        videos.addAll(videoDao.getAll());
        handler.post(()->{
            iUpdateUi.update(videos);
        });
    }

    public List<VideoEntity> getVideos() {
        return videos;
    }
}
