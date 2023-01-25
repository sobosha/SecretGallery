package com.example.gallerysecret.Main;

import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.DataBase.VideoEntity;

import java.util.List;

public interface IUpdateUiVideo {
    void update(List<VideoEntity> videoEntities);
}
