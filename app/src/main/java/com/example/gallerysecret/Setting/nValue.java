package com.example.gallerysecret.Setting;


import android.app.ActivityManager;
import android.content.Context;

import com.example.gallerysecret.MainActivity;

public class nValue {

    private static nValue global;

    public static void setGlobal(nValue global) {
        nValue.global = global;
    }

    public static nValue getGlobal()
    {
        if(global != null)
            return global;
        else
            return new nValue();
    }
    private nValue()
    {
        global = this;
    }

    public static String marketModel = "bazar";
    /* myket   bazar   iranapps   */
    public static String getValidateMarket()
    {
        return marketModel;
    }


    public String StartjoinModel;

    private String joinModel;
    public String getJoinModel() {
        return joinModel;
    }

    public void setJoinModel(String joinModel) {
        this.joinModel = joinModel;
    }

    /*-------------------------------------------------------------------------------------------------------*/
    boolean update;
    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    /*-------------------------------------------- circle counter-----------------------------------------------------------*/

    public String getFirstResponseData() {
        return firstResponseData;
    }

    public void setFirstResponseData(String firstResponseData) {
        this.firstResponseData = firstResponseData;
    }

    public String firstResponseData = "";

    public String getSecondResponseData() {
        return secondResponseData;
    }

    public void setSecondResponseData(String secondResponseData) {
        this.secondResponseData = secondResponseData;
    }

    public String secondResponseData = "";
    /*----------------------------------------   pages for crash log -----------------------------*/
    public String firstPage = "";
    public String secondPage = "";
    public String thirdPage = "";

    public String getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(String firstPage) {
        this.firstPage = firstPage;
    }

    public String getSecondPage() {
        return secondPage;
    }

    public void setSecondPage(String secondPage) {
        this.secondPage = secondPage;
    }

    public String getThirdPage() {
        return thirdPage;
    }

    public void setThirdPage(String thirdPage) {
        this.thirdPage = thirdPage;
    }

    /*---------------------------------------------------------*/

    public Context getContext() {

        return MainActivity.getGlobal();
    }

    private boolean sync = false ;

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    boolean dialogEvent = false ;
    public boolean isDialogEvent() {
        return dialogEvent;
    }

    public void setDialogEvent(boolean dialogEvent) {
        this.dialogEvent = dialogEvent;
    }

    /*---------------------------------------------------------------------------------------------------------------------------------------------*/
    int backPage;

    public int getBackPage() {
        return backPage;
    }

    public void setBackPage(int backPage) {
        this.backPage = backPage;
    }

    boolean blockBack;

    public boolean isBlockBack() {
        return blockBack;
    }

    public void setBlockBack(boolean blockBack) {
        this.blockBack = blockBack;
    }

    private boolean userInApp = false ;

    public boolean isUserInApp() {
        return userInApp;
    }

    public void setUserInApp(boolean userInApp) {
        this.userInApp = userInApp;
    }


//    if ram is below 4GB
    public boolean isOldDevice()
    {
        ActivityManager actManager = (ActivityManager) MainActivity.getGlobal().getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        long totalMemory = memInfo.totalMem;
        return (totalMemory / (1024 * 1024)) <= 4000;
    }
}
