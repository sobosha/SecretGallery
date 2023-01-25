package com.example.gallerysecret.Main;


import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.gallerysecret.Main.DataBase.VideoEntity;
import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomFragment;
import com.example.gallerysecret.Setting.IAnimationEnd;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mAnimation;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.io.File;
import java.net.URI;

public class fragment_propertiseVideo extends CustomFragment {
    VideoEntity videoEntity;
    int pos,all;
    PlayerView videoView;
    SimpleExoPlayer player;
    RelativeLayout status;
    public VideoEntity getVideoEntity() {
        return videoEntity;
    }

    public void setVideoEntity(VideoEntity videoEntity) {
        this.videoEntity = videoEntity;
    }

    @Override
    public int layout() {
        return R.layout.fragment_propertisevideo;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public void onCreateMyView() {
        status=MainActivity.getGlobal().findViewById(R.id.top_status);
        status.setVisibility(View.GONE);
        videoView=parent.findViewById(R.id.videoview_shower);
        ImageView delete=parent.findViewById(R.id.delete_video);
        ImageView back=parent.findViewById(R.id.back);
        TextView position=parent.findViewById(R.id.position_video);
        MediaController mediaController = new MediaController(getContext());
        position.setText(pos+1+"/"+all);
        player = new SimpleExoPlayer.Builder(getContext()).build();
        videoView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(videoEntity.getVideo()));
        player.setMediaItem(mediaItem);
        player.prepare();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(back, 1, 1, 0.9f, 0.9f, 0, 100), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        player.stop();
                        fragment_list fraglist=new fragment_list();
                        fraglist.setType("video");
                        MainActivity.getGlobal().FinishFragStartFrag(fraglist);
                    }
                });

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(delete, 1, 1, 0.9f, 0.9f, 0, 100), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        player.stop();
                        mediaController.removeAllViews();
                        fragment_list fragment_list=new fragment_list();
                        fragment_list.setType("video");
                        fragment_list.setRestorevideo(videoEntity);
                        MainActivity.getGlobal().DialogShow();
                        MainActivity.getGlobal().FinishFragStartFrag(fragment_list);
                    }
                });

            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.play();

            }
        });

    }

    @Override
    public void mBackPressed() {
        super.mBackPressed();
        player.stop();
        fragment_list fraglist=new fragment_list();
        fraglist.setType("video");
        MainActivity.getGlobal().FinishFragStartFrag(fraglist);
    }
}
