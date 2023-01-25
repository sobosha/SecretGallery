package com.example.gallerysecret.Main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomFragment;
import com.example.gallerysecret.Setting.IAnimationEnd;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mAnimation;

import java.io.File;

import ozaydin.serkan.com.image_zoom_view.ImageViewZoom;

public class fragment_propertiseImage extends CustomFragment {
    ImageEntity imageEntity;
    ImageViewZoom image;
    TextView text_position;
    RelativeLayout status;
    ImageView share,delete,back;
    int all,position;

    public void setAll(int all) {
        this.all = all;
    }


    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int layout() {
        return R.layout.fragment_propertiseimage;
    }

    @Override
    public void onCreateMyView() {
        status=MainActivity.getGlobal().findViewById(R.id.top_status);
        status.setVisibility(View.GONE);
        image=parent.findViewById(R.id.imageview_shower);
        image.setImageURI(Uri.parse(imageEntity.getImage()));
        share=parent.findViewById(R.id.share_image);
        delete=parent.findViewById(R.id.delete_image);
        back=parent.findViewById(R.id.back);
        text_position=parent.findViewById(R.id.position_image);
        text_position.setText(position+1+"/"+all);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(delete, 1, 1, 0.9f, 0.9f, 0, 100), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        fragment_list fraglist=new fragment_list();
                        fraglist.setType("image");
                        fraglist.setRestore(imageEntity);
                        MainActivity.getGlobal().DialogShow();
                        MainActivity.getGlobal().FinishFragStartFrag(fraglist);
                    }
                });

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(share, 1, 1, 0.9f, 0.9f, 0, 100), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("image/*");
                        File file=new File(imageEntity.getImage());
                        if(file.exists()) {
                            Drawable mDrawable = image.getDrawable();
                            Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();
                            String path = MediaStore.Images.Media.insertImage(MainActivity.getGlobal().getContentResolver(), mBitmap, "Image I want to share", null);
                            Uri uri = Uri.parse(path);
                            intent.putExtra(Intent.EXTRA_STREAM,uri);
                            startActivity(Intent.createChooser(intent, "Share Image"));
                        }
                    }
                });

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(back, 1, 1, 0.9f, 0.9f, 0, 100), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        fragment_list list=new fragment_list();
                        list.setType("image");
                        MainActivity.getGlobal().FinishFragStartFrag(list);
                    }
                });

            }
        });
    }

    public ImageEntity getImageEntity() {
        return imageEntity;
    }

    public void setImageEntity(ImageEntity imageEntity) {
        this.imageEntity = imageEntity;
    }

    @Override
    public void mBackPressed() {
        super.mBackPressed();
        fragment_list list=new fragment_list();
        list.setType("image");
        MainActivity.getGlobal().FinishFragStartFrag(list);
    }
}
