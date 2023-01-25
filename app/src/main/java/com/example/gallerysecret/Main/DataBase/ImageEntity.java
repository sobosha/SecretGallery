package com.example.gallerysecret.Main.DataBase;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image")
public class ImageEntity{

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="imagepath")
    private String image;

    @ColumnInfo(name="imageorginalpath")
    private String imageorginalpath;

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageorginalpath() {
        return imageorginalpath;
    }

    public void setImageorginalpath(String imageorginalpath) {
        this.imageorginalpath = imageorginalpath;
    }
}
