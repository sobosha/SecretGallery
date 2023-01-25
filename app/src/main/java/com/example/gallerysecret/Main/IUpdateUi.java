package com.example.gallerysecret.Main;

import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.DataBase.VideoEntity;

import java.util.List;

public interface IUpdateUi {
    void update(List<ImageEntity> imageEntities);
}
