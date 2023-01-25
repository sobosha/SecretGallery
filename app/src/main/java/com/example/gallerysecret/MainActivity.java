package com.example.gallerysecret;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.gallerysecret.Core.BuyResponse;
import com.example.gallerysecret.Core.DataModelResponse;
import com.example.gallerysecret.Core.IView;
import com.example.gallerysecret.Main.DialogProgress;
import com.example.gallerysecret.Main.PermissionTask;
import com.example.gallerysecret.Main.fragment_password;
import com.example.gallerysecret.Main.fragment_splash;
import com.example.gallerysecret.Setting.Presenter;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mAnimation;
import com.example.gallerysecret.Setting.mFragment;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.mLocalData;
import com.example.gallerysecret.Setting.nValue;
import com.example.gallerysecret.util.IabHelper;
import com.example.gallerysecret.util.IabResult;


import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private static MainActivity global;
    public RelativeLayout DialogMain;
    public ProgressBar progressBarMain;
    public int position=0;

    public static MainActivity getGlobal() {
        return global;
    }

    public MainActivity() {
        global = this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        DialogMain=findViewById(R.id.relMainDialogs);
        DialogMain.addView(new DialogProgress(getApplicationContext(),R.layout.dialog_progress));
        DialogMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        progressBarMain=findViewById(R.id.progress_save);
        getPresenter();
        CheckMarketStore();
        MainActivity.getGlobal().FinishFragStartFrag(new fragment_splash());
    }

    public void DialogShow(){
        DialogMain.setVisibility(VISIBLE);
    }

    public void DialogGone(){
        DialogMain.setVisibility(View.GONE);
    }

    public mFragment getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(mFragment currentFragment) {
        this.currentFragment = currentFragment;
    }




    private mFragment currentFragment;

    public void FinishFragStartFrag(mFragment newFragment) {
        //Presenter.get_global().cancelReq();
        currentFragment = newFragment;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.fade_show, R.anim.fade_hide);
        ft.replace(R.id.relMaster, newFragment);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }


    @Override
    public void onBackPressed() {
        currentFragment.mBackPressed();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                    permissionTask.Allow();
                }  else {
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                    permissionTask.Deny();
                }
                return;
        }
    }
    PermissionTask permissionTask;
    public void setPermissionHandler(PermissionTask permissionTask){
        this.permissionTask=permissionTask;
    }

    /*-----------------------------------     buy   --------------------------------------*/
    boolean mIsMarketStore = false;

    public boolean ismIsMarketStore() {
        return mIsMarketStore;
    }

    IabHelper mHelper;

    public IabHelper getmHelper() {
        return mHelper;
    }
    private void CheckMarketStore() {

        if (nValue.marketModel.equals("myket")) {
            mHelper = new IabHelper(this, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbUGHn4TCEr7fREojl4hGXYTMdIp+KV9bXzQ/ChHu+2Mu6i2obWIwE0IrtgX5fHThGWwF/sZBBPHUqXCNQrrqVY/PCRTxjautK934WIr/4Sgz/EKAfKkqT1ETJm1RPXh6kCM0ulsd0OsuLh7y8wxwtTMIO+z5Dly9uJ9q19O74FQIDAQAB");
        } else if (nValue.marketModel.equals("bazar")) {
            mHelper = new IabHelper(this, "MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwC4j3SMDQ3gTazUmxlF4O12o4Jd6HXCRDBDpbQ6uTO0MWEkn/nQxx3fTvuej5DGJ0zuNo/TdO4WIdXwKqyXW52zZiDjrPYhOYqZLrXk6QC6bPMMuUZhL1hRGJYanC//bYQfXrnLhSSCGeLL7oFjnaIOdoL/8y/etJQSV6u44xHG02PpvLvBWKFAEfHZxObdUH5CUszXKd3tG2akbHklux6OucotU5/qjq7z/782leUCAwEAAQ==");
        }
        try {

            mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
                public void onIabSetupFinished(IabResult result) {
                    mIsMarketStore = result.isSuccess();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        *//*if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }*//*



    }*/

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.clear();
    }

    public void getPresenter(){
        Presenter.get_global().OnCreate(MainActivity.getGlobal(), "https://tools.hooshejavandeh.com/", "");

        if(mLocalData.getToken(MainActivity.getGlobal()).equals("")) {
            Presenter.get_global().GetAction(new IView<DataModelResponse>() {
                @Override
                public void SendRequest() {

                }

                @Override
                public void OnSucceed(DataModelResponse object) {
                    mLocalData.SetToken(MainActivity.getGlobal(), object.getData().getToken());
                    //Toast.makeText(MainActivity.getGlobal(), mLocalData.getToken(MainActivity.getGlobal()), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void OnError(String error, int statusCode) {
                    //Toast.makeText(MainActivity.getGlobal(), "توکن نگرفت"+statusCode, Toast.LENGTH_SHORT).show();

                }
            }, "users", "create", "1", DataModelResponse.class);
        }
        else{
            Presenter.get_global().GetAction(new IView<BuyResponse>() {
                @Override
                public void SendRequest() {

                }

                @Override
                public void OnSucceed(BuyResponse object) {
                    //Toast.makeText(MainActivity.getGlobal(),object.getSuccess(),Toast.LENGTH_SHORT).show();
                    if(object.getSuccess().equals("false"))
                        mLocalData.setUserInfo(MainActivity.getGlobal(),false);
                }

                @Override
                public void OnError(String error, int statusCode) {

                }
            }, "users", "getBuy", "gallery", BuyResponse.class);
        }
    }


}