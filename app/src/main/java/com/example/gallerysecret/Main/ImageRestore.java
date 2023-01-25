package com.example.gallerysecret.Main;

import android.os.Handler;
import android.os.Looper;

import com.example.gallerysecret.Main.DataBase.ImageDao;
import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.IUpdateUi;

import java.util.ArrayList;
import java.util.List;

public class ImageRestore implements Runnable {
    ImageDao imageDao;
    List<ImageEntity> images;
    ImageEntity image;
    private IUpdateUi iUpdateUi;
    private Handler handler=new Handler(Looper.getMainLooper());
    public ImageRestore(ImageDao imageDao ,ImageEntity image, IUpdateUi iUpdateUi) {
        this.imageDao=imageDao;
        images=new ArrayList<>();
        this.iUpdateUi=iUpdateUi;
        this.image=image;
    }

    @Override
    public void run() {
        imageDao.deleteById(image.getId());
        images=imageDao.getAll();
        handler.post(()->{
            iUpdateUi.update(images);
        });
    }

    public List<ImageEntity> getImages() {
        return images;
    }
}
