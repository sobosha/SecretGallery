package com.example.gallerysecret.Main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.gallerysecret.Core.IView;
import com.example.gallerysecret.Setting.CustomClasses.CustomRel;
import com.example.gallerysecret.Setting.Presenter;
import com.example.gallerysecret.Setting.reqBuy;
import com.example.gallerysecret.Setting.reqBuyResult;
import com.example.gallerysecret.StoreParent;

public class Dialog extends CustomRel {
    StoreParent storeParent;
    String offCode="";
    public Dialog(Context context, int layout) {
        super(context, layout);
    }

    public Dialog(Context context, int layout,StoreParent storeParent) {
        super(context, layout);
        this.storeParent=storeParent;

    }


}
