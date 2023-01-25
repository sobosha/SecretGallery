package com.example.gallerysecret.Core;

public class CrashRequest {


    private String s; //crash text - شامل شماره خطی ک ارور خورده ، متن ارور و ...
    private String d;//device info
    private String r;


    private String r2;
    private String tag;// hashtag telegram - نام صفحه ای که ارور در ان بوجود امده
    private int self; // 1 =کانالی که ارور های خودمون داخلش ثبت میشه
    // - 0 = کانالی که ارور های کاربران رو نمایش میده


    public CrashRequest(String s, String d, String tag, String r, String r2 , int self) {
        this.d = d;
        this.s = s;
        this.tag = tag;
        this.r = r;
        this.r2 = r2;
        this.self = self;
    }
}
