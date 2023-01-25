package com.example.gallerysecret;


import com.example.gallerysecret.Setting.ErrorResult;

public class MarketResult {
    boolean success;
    int code ;
    ErrorResult error ;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ErrorResult getError() {
        return error;
    }

    public void setError(ErrorResult error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }
}
