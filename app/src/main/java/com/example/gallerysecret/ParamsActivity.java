package com.example.gallerysecret;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gallerysecret.Main.fragment_list;
import com.example.gallerysecret.Setting.mLocalData;
import com.google.android.material.snackbar.Snackbar;


public class ParamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);
        if (getIntent().getData().getQueryParameter("status") != null) {
            if (getIntent().getData().getQueryParameter("status").equals("true")) {
                try {

                    if (getIntent().getData().getQueryParameter("type") != null) {
                        if (getIntent().getData().getQueryParameter("type").equals("gallery")) {
                            fragment_list.getInstance().Dialog.removeAllViews();
                            fragment_list.getInstance().showDialog = false;
                            fragment_list.getInstance().status.setVisibility(View.VISIBLE);
                            Snackbar.make(MainActivity.getGlobal().getCurrentFragment().getView(),"پرداخت با موفقیت انجام شد",1000).show();
                            mLocalData.setUserInfo(MainActivity.getGlobal(),true);
                            /*new RequestManager(getApplicationContext()).setUserProperties();
                            MainActivity.getGlobal().ShowMessageBox(new RelMessageBox(MainActivity.getGlobal()).ExitButtonWithClick("success", "خرید " + getIntent().getData().getQueryParameter("quantity") + "  قلب با موفقیت انجام شد \uD83C\uDF38\uD83D\uDE00", view -> {
                                mAnimation.PressClick(view);
                                MainActivity.getGlobal().HideMessageBox();
                            }).setTextBtnOk("باشه"));
                            //*/
                            /*if (nValue.getGlobal().isBuyPackage())
                                ((FragMission) MainActivity.getGlobal().getCurrentFragment()).onSuccedBuy();
                            else if (nValue.getGlobal().isBuyArticle()) {
                                nValue.getGlobal().setBuyArticle(false);
                                ((FragListArticleWithPDF) MainActivity.getGlobal().getCurrentFragment()).update();
                            } else {
                                *//*MainActivity.getGlobal().HideMessageBox();
                                MainActivity.getGlobal().hideMainDialogs();*//*
                            }*/
                        }
                    } else {
                        Snackbar.make(MainActivity.getGlobal().getCurrentFragment().getView(),"پرداخت ناموفق",1000).show();

                        /*MainActivity.getGlobal().ShowMessageBox(new RelMessageBox(MainActivity.getGlobal()).ExitButtonWithClick("error", " خریدت " + "انجام نشد ☹️\uD83D\uDC94", view -> {
                            mAnimation.PressClick(view);
                            MainActivity.getGlobal().HideMessageBox();
                        }).setTextBtnOk("متوجه شدم"));*/
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                fragment_list.getInstance().Dialog.removeAllViews();
                fragment_list.getInstance().showDialog = false;
                fragment_list.getInstance().status.setVisibility(View.VISIBLE);
                Snackbar.make(MainActivity.getGlobal().getCurrentFragment().getView(),"پرداخت ناموفق",1000).show();
                /*MainActivity.getGlobal().ShowMessageBox(new RelMessageBox(MainActivity.getGlobal()).ExitButtonWithClick("error", " خریدت " + "انجام نشد ☹️\uD83D\uDC94", view -> {
                    mAnimation.PressClick(view);
                    MainActivity.getGlobal().HideMessageBox();
                }).setTextBtnOk("متوجه شدم"));*/
            }

            Intent openMainActivity = new Intent(this, MainActivity.class);
            startActivity(openMainActivity);
        }
    }


}
