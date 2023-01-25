package com.example.gallerysecret.Core;



import java.util.List;

public class DataModelResponse {

    boolean success ;
    int bz,cPost,cBookmark,cEvent ,userID;
    Data data;
    String text,link , tokenBot;
    int sandbox;

    public int getSandbox() {
        return sandbox;
    }

    public String getText() {
        return text;
    }

    public int getUserID() {
        return userID;
    }


    public String getLink() {
        return link;
    }

    public int getBz() {
        return bz;
    }


    public Data getData() {
        return data;
    }

    public int getcPost() {
        return cPost;
    }

    public int getcBookmark() {
        return cBookmark;
    }

    public int getcEvent() {
        return cEvent;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getTokenBot() {
        return tokenBot;
    }

}
