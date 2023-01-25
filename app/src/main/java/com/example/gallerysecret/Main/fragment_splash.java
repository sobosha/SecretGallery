package com.example.gallerysecret.Main;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gallerysecret.Core.Data;
import com.example.gallerysecret.Core.DataModelResponse;
import com.example.gallerysecret.Core.IView;
import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomFragment;
import com.example.gallerysecret.Setting.Presenter;
import com.example.gallerysecret.Setting.mLocalData;

import java.util.Date;

public class fragment_splash extends CustomFragment {
    ProgressBar progressBar;
    int progressStatus=0;
    Thread temp;
    private Handler handler = new Handler();
    @Override
    public int layout() {
        return R.layout.fragment_splash;
    }

    @Override
    public void onCreateMyView() {
        progressBar=parent.findViewById(R.id.progress_splash);

        temp=new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            if(progressStatus>=98){
                                MainActivity.getGlobal().FinishFragStartFrag(new fragment_password());
                                temp.interrupt();
                            }
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        temp.start();

    }

    @Override
    public void mBackPressed() {
        super.mBackPressed();
    }
}
