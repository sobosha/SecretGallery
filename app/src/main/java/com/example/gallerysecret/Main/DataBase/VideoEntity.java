package com.example.gallerysecret.Main.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "video")
public class VideoEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="videopath")
    private String video;

    @ColumnInfo(name="videoorginalpath")
    private String videoorginalpath;

    public int getId() {
        return id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoorginalpath() {
        return videoorginalpath;
    }

    public void setVideoorginalpath(String videoorginalpath) {
        this.videoorginalpath = videoorginalpath;
    }
}
