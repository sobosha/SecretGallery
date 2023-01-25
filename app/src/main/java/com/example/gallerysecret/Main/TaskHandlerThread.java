package com.example.gallerysecret.Main;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class TaskHandlerThread implements Runnable {
    ITaskInMain iTaskInMain;
    ITaskInBackground iTaskInBackground;
    private Handler handler = new Handler(Looper.getMainLooper());
    public TaskHandlerThread(ITaskInMain iTaskInMain,ITaskInBackground iTaskInBackground) {
        this.iTaskInMain=iTaskInMain;
        this.iTaskInBackground=iTaskInBackground;
    }


    @Override
    public void run() {
        iTaskInBackground.TaskBack();
        handler.post(()->{
            iTaskInMain.Task();
        });
    }
}
