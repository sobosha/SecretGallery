package com.example.gallerysecret.Setting.CustomClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class CustomRel extends RelativeLayout {
    public CustomRel(Context context , int layout) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(layout , this , true);
    }
}
