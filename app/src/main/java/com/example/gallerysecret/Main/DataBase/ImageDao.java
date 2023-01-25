package com.example.gallerysecret.Main.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDao {
    @Query("SELECT * FROM image")
    List<ImageEntity> getAll();

    @Insert
    void insertAll(ImageEntity... image);

    @Query("Delete FROM image WHERE id=:imageid")
    abstract void deleteById(int imageid);
}
