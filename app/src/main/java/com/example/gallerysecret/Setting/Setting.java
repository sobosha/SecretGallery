package com.example.gallerysecret.Setting;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.animation.Animation;

import com.example.gallerysecret.MainActivity;

public class Setting {
    public static void OnAnimationEnd (Animation animation , IAnimationEnd end) {
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }
            @Override
            public void onAnimationEnd(Animation animation) { end.TheEnd(); }
            @Override
            public void onAnimationRepeat(Animation animation) { }});
    }

    public static String getVersionName() {
        try {
            PackageInfo pInfo = MainActivity.getGlobal().getPackageManager().getPackageInfo(MainActivity.getGlobal().getPackageName(), 0);
            return pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isNetworkConnect() {
        ConnectivityManager conMgr = (ConnectivityManager) nValue.getGlobal().getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null)
            return false;
        else
            return true;
    }

}


