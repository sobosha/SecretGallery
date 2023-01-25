package com.example.gallerysecret.Core;

public class globalResult {

    int status ;
    private boolean success  , package_active;
    String instagram ;
    int artice_id  ;
    String img ;

    public boolean isSuccess() {
        return success;
    }

    public int getStatus() {
        return status;
    }

    public String getInstagram() {
        return instagram;
    }

    public int getArtice_id() {
        return artice_id;
    }


    public boolean isPackage_active() {
        return package_active;
    }

    public void setPackage_active(boolean package_active) {
        this.package_active = package_active;
    }

    public String getImg() {
        return img;
    }
}
