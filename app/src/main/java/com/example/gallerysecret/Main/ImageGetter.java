package com.example.gallerysecret.Main;

import android.os.Handler;
import android.os.Looper;

import com.example.gallerysecret.Main.DataBase.ImageDao;
import com.example.gallerysecret.Main.DataBase.ImageEntity;

import java.util.ArrayList;
import java.util.List;

public class ImageGetter implements Runnable {
    ImageDao imageDao;
    List<ImageEntity> images;
    private IUpdateUi iUpdateUi;
    private Handler handler=new Handler(Looper.getMainLooper());
    public ImageGetter(ImageDao imageDao , IUpdateUi iUpdateUi) {
        this.imageDao=imageDao;
        images=new ArrayList<>();
        this.iUpdateUi=iUpdateUi;
    }

    @Override
    public void run() {
        images.clear();
        images.addAll(imageDao.getAll());
        handler.post(()->{
            iUpdateUi.update(images);
        });
    }

    public List<ImageEntity> getImages() {
        return images;
    }
}
