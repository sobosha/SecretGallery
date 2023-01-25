package com.example.gallerysecret.Setting.CustomClasses;

import java.util.List;

public interface IAdapter <T , P> {
    void onBind (int position , List<T> list , P rel , int selectItem , CustomAdapter<T , P> customAdapter);
}
