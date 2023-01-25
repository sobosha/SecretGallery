package com.example.gallerysecret.Main.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VideoDao {
    @Query("SELECT * FROM video")
    List<VideoEntity> getAll();

    @Insert
    void insertAll(VideoEntity... video);

    @Query("Delete FROM video WHERE id=:videoid")
    abstract void deleteById(int videoid);
}
