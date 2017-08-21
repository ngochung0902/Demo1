package com.company.qts.demo1;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.company.qts.customview.VideoView;
import com.company.qts.helper.QTSHelp;

/**
 * Created by MyPC on 21/08/2017.
 */
public class ActShowMovies1 extends AppCompatActivity {
    private VideoView Videoview;
    private TextView tvDetails;
    private ImageView ivPause,img_share,img_mute,img_fullscreen;
    private LinearLayout ln_video;
    Toolbar toolbar;
    int position = 0;
    int displayHeight, displayWidth;
    PackageInfo pInfo = null;
    int versionCode = 1;
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_show_movies);
        ln_video = (LinearLayout) findViewById(R.id.ln_video);
        img_mute = (ImageView) findViewById(R.id.img_mute);
        img_fullscreen = (ImageView) findViewById(R.id.img_fullscreen);
        img_share = (ImageView) findViewById(R.id.img_share);
        position = getIntent().getIntExtra("position", 0);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        tvDetails = (TextView) findViewById(R.id.tvDetails);
        Videoview = (VideoView) findViewById(R.id.vdView);
        ivPause = (ImageView) findViewById(R.id.ivPause);

        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionCode = pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {

        }
        displayWidth = QTSHelp.GetWidthDevice(getApplicationContext());
        displayHeight = QTSHelp.GetHeightDevice(getApplicationContext());

        int id = this.getRawResIdByName("myvideo");
        Videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
        Videoview.start();
        ln_video.setVisibility(View.GONE);
        QTSHelp.setLayoutView(ivPause,QTSHelp.GetWidthDevice(this)/5,QTSHelp.GetWidthDevice(this)/5);

        Videoview.setDimensions(displayWidth, displayHeight*2/5);
        Videoview.getHolder().setFixedSize(displayWidth, displayHeight*2/5);
        Videoview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Videoview.pause();
                    ln_video.setVisibility(View.VISIBLE);
                    return true;
                }else{
                    return false;
                }
            }
        });
        Videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ln_video.setVisibility(View.VISIBLE);
            }
        });
        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Videoview.start();
                ln_video.setVisibility(View.GONE);
            }
        });

        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });

        img_fullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Videoview.setDimensions(displayHeight, displayWidth);
                Videoview.getHolder().setFixedSize(displayHeight, displayWidth);
                toolbar.setVisibility(View.GONE);
            }
        });

        getWH();
    }

    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    public void getWH(){
        Configuration config = getResources().getConfiguration();
        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Videoview.setDimensions(displayHeight, displayWidth);
            Videoview.getHolder().setFixedSize(displayHeight, displayWidth);
            toolbar.setVisibility(View.GONE);
        }else{
            toolbar.setVisibility(View.VISIBLE);
            Videoview.setDimensions(displayWidth, displayHeight*2/5);
            Videoview.getHolder().setFixedSize(displayWidth, displayHeight*2/5);
        }
    }
}
