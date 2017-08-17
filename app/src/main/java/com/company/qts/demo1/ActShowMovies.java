package com.company.qts.demo1;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class ActShowMovies extends AppCompatActivity {
    private VideoView videoview_movies;
    private int position = 0;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_show_movies);
        videoview_movies = (VideoView) findViewById(R.id.videoview_movies);

        // Set the media controller buttons
        if (mediaController == null) {
            mediaController = new MediaController(ActShowMovies.this);

            // Set the videoView that acts as the anchor for the MediaController.
            mediaController.setAnchorView(videoview_movies);


            // Set MediaController for VideoView
            videoview_movies.setMediaController(mediaController);
//            String videoUrl="http://www.youtubemaza.com/files/data/366/Tom%20And%20Jerry%20055%20Casanova%20Cat%20(1951).mp4";
//            Uri video = Uri.parse(videoUrl);
//            videoview_movies.setVideoURI(video);
        }


        try {
//            String videoUrl="http://www.youtubemaza.com/files/data/366/Tom%20And%20Jerry%20055%20Casanova%20Cat%20(1951).mp4";
//            Uri video = Uri.parse(videoUrl);
//            videoview_movies.setVideoURI(video);
            // ID of video file.
            int id = this.getRawResIdByName("myvideo");
            videoview_movies.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoview_movies.requestFocus();


        // When the video file ready for playback.
        videoview_movies.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoview_movies.seekTo(position);
                if (position == 0) {
                    videoview_movies.start();
                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mediaController.setAnchorView(videoview_movies);
                    }
                });
            }
        });

    }

    // Find ID corresponding to the name of the resource (in the directory raw).
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }


    // When you change direction of phone, this method will be called.
    // It store the state of video (Current position)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Store current position.
        savedInstanceState.putInt("CurrentPosition", videoview_movies.getCurrentPosition());
        videoview_movies.pause();
    }


    // After rotating the phone. This method is called.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Get saved position.
        position = savedInstanceState.getInt("CurrentPosition");
        videoview_movies.seekTo(position);
    }
}
