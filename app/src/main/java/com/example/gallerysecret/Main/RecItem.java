package com.example.gallerysecret.Main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.gallerysecret.ImageCompresor.IImageCompressTaskListener;
import com.example.gallerysecret.ImageCompresor.ImageCompressTask;
import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.DataBase.VideoEntity;
import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomRel;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.Inflater;

public class RecItem extends RelativeLayout {
    Bitmap bitmapSend;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(1);
    public RecItem(Context context,String type) {
        super(context);
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(type.equals("image"))
            inflater.inflate(R.layout.rec_item_image,this,true);
        else if(type.equals("video"))
            inflater.inflate(R.layout.rec_item_video,this,true);
        else if(type.equals("question"))
            inflater.inflate(R.layout.rec_item_question,this,true);

    }

    public void imageitem(ImageEntity item,int pos,int all){
        ImageView imageView=findViewById(R.id.imageview_item);
        Glide.with(getContext()).load(item.getImage()).into(imageView);
        //imageView.setImageURI(Uri.parse(item.getImage()));
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_propertiseImage fragImage=new fragment_propertiseImage();
                fragImage.setImageEntity(item);
                fragImage.setAll(all);
                fragImage.setPosition(pos);
                MainActivity.getGlobal().FinishFragStartFrag(fragImage);
            }
        });
    }

    public void videoitem(VideoEntity item,int pos,int all){
        ImageView videoView=findViewById(R.id.videoView_item);
        /*videoView.setVideoURI(Uri.parse(item.getVideo()));
        videoView.seekTo(1);*/
        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(item.getVideo(),
                MediaStore.Images.Thumbnails.MINI_KIND);
        videoView.setImageBitmap(thumb);
        videoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_propertiseVideo temp=new fragment_propertiseVideo();
                temp.setVideoEntity(item);
                temp.setAll(all);
                temp.setPos(pos);
                MainActivity.getGlobal().FinishFragStartFrag(temp);
            }
        });
    }

    public void question(Question q,int position,RelativeLayout relrec){
        TextView text=findViewById(R.id.textview_rec_question);
        text.setText(q.getQuestion());
        text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getGlobal().position=position;
                TextView show=MainActivity.getGlobal().findViewById(R.id.textview_aboveRecQuestion);
                show.setText(q.getQuestion());
                TextView show2=MainActivity.getGlobal().findViewById(R.id.textview_showquestion);
                show2.setText(q.getQuestion());
                relrec.setVisibility(GONE);
            }
        });
    }

    private final IImageCompressTaskListener iImageCompressTaskListener = new IImageCompressTaskListener() {
        @Override
        public void onComplete(List<File> compressed) {
            File file = compressed.get(0);
            bitmapSend = BitmapFactory.decodeFile(file.getAbsolutePath());
        }

        @Override
        public void onError(Throwable error) {

        }
    };
}
