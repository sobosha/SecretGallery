package com.example.gallerysecret.Main;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomFragment;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mLocalData;

import java.io.File;


import io.alterac.blurkit.BlurLayout;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class fragment_menu extends CustomFragment {
    ImageView image,video;
    RelativeLayout exitDialog,status;
    BlurLayout blurLayout;
    @Override
    public int layout() {
        return R.layout.fragment_menu;
    }
    Context context;
    boolean showDialog=false;
    @Override
    public void onCreateMyView() {
        status=MainActivity.getGlobal().findViewById(R.id.top_status);
        status.setVisibility(View.GONE);
        ((TextView)MainActivity.getGlobal().findViewById(R.id.title)).setText("منو");
        exitDialog=parent.findViewById(R.id.rel_exit);
        context=getContext();
        image=parent.findViewById(R.id.image);
        video=parent.findViewById(R.id.video);

//        if(!checkPermission()){
//            requestPermission();
//        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_list fr=new fragment_list();
                fr.setType("image");
                MainActivity.getGlobal().FinishFragStartFrag(fr);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_list fr=new fragment_list();
                fr.setType("video");
                MainActivity.getGlobal().FinishFragStartFrag(fr);
            }
        });

        /*PackageManager m = MainActivity.getGlobal().getPackageManager();
        String s = MainActivity.getGlobal().getPackageName();
        PackageInfo p = null;
        try {
            p = m.getPackageInfo(s, 0);
            s = p.applicationInfo.dataDir;
            File f=new File(s);
            Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }*/

    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            int result = 0;
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                result = context.checkSelfPermission(READ_EXTERNAL_STORAGE);
                int result1 = context.checkSelfPermission(WRITE_EXTERNAL_STORAGE);
                return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
            }
        }
        return true;
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s",context.getPackageName())));
                startActivityForResult(intent, 2296);
            } catch (Exception e) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 2296);
            }
        } else {
            //below android 11
            ActivityCompat.requestPermissions(MainActivity.getGlobal(), new String[]{WRITE_EXTERNAL_STORAGE}, 10);
        }
    }

    @Override
    public void mBackPressed() {
        super.mBackPressed();
        if(!showDialog) {
            exitDialog.addView(new Dialog(getContext(), R.layout.dialogexit));
            showDialog=true;
            /*status.setVisibility(View.INVISIBLE);*/
            dialog();
        }
        else if(showDialog){
            exitDialog.removeAllViews();
            /*status.setVisibility(View.VISIBLE);*/
            showDialog=false;
        }
    }

    private void dialog() {
        TextView exit,noExit;
        noExit=parent.findViewById(R.id.btn_exit_No);
        exit=parent.findViewById(R.id.btn_exit_Yes);
        noExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitDialog.removeAllViews();
                /*status.setVisibility(View.VISIBLE);*/
                showDialog=false;
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getGlobal().finish();
            }
        });
        blurLayout=parent.findViewById(R.id.blurlayuot);
        blurLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitDialog.removeAllViews();
                /*status.setVisibility(View.VISIBLE);*/
                showDialog=false;
            }
        });
    }
}
