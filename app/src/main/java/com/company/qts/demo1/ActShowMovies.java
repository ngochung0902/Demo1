package com.company.qts.demo1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.company.qts.customview.VideoView;
import com.company.qts.helper.QTSHelp;

public class ActShowMovies extends AppCompatActivity {
    private VideoView Videoview;
    private TextView tvDetails;
    private ImageView ivPause,img_share,img_mute,img_fullscreen,ivPlay;
    private LinearLayout ln_video;
    Toolbar toolbar;
    int position = 0;
    int displayHeight, displayWidth;
    PackageInfo pInfo = null;
    int versionCode = 1;
    int a = 0;
    int b = 0;
    String[] arrVideos = {"<h4>Introduction</h4><p>Every week, thousands of Australians have surgery, and you're one of them, which means you need to be prepared.</p>The <em><strong>My Surgery Journey</strong></em> app provides information about the time before surgery. You should use it together with your family and talk about the information. The app will help you get ready for surgery, remind you of important dates and help you get to the hospital. <p>Ask your local doctor or surgeon if you have any questions.</p> <p>If you're late to hospital, miss your appointment, or haven't followed your doctor's instructions your surgery may be delayed or even cancelled.</p> <p>When surgery is cancelled it's not possible to simply bring in the next patient, as the theatre has been set up just for you.</p> So, make the most of your <em><strong>My Surgery Journey</strong></em> app to ensure you're ready for surgery.",
            "<h4>Waiting times</h4><p>Surgery waiting times can be long. It may take days, weeks or even months from the time you first visit your GP to when you have your surgery.</p><p>Many things can happen to change your waiting time so the hospital will only give you an estimated waiting time until they really know when to contact you stating the exact time of your surgery.</p>It is important to let the Hospital know if you no longer require surgery or have already had it elsewhere.",
            "<h4>Medications</h4><p>Any medicines you're taking could react with the anaesthetic or other medicines you may receive during surgery. It's important to stop taking some medicines several weeks before surgery. Your doctor will tell you exactly what medicines to stop and when.</p><p>Remember, medicine is a science, not guesswork.</p><p>If you are not sure about something, simply call your doctor.</p><p>It's even important to tell your doctor if you are taking natural remedies such as fish oil, and as good as the human memory can be, it's far from perfect, so be sure to mark your medicine stop times in a diary.</p>If you take any blood thinning medicines you must get special instructions from your doctor or the hospital.",
            "<h4>Fasting</h4><p>For most surgery you'll require medicine to go to sleep. When you're asleep your throat muscles relax and any food in your stomach can escape and get into your lungs.</p><p>That's why, it's important to stop eating anything at least 6 hoursbefore your surgery.</p><p>Hospital staff will contact you in the days before your surgery with exact instructions.</p><p>Fasting means going without all food and liquid. Sometimes in hospital we call this “Nil By Mouth”.  Fasting is needed before general anaesthesia or sedation.</p>    •  You can have solid food until 6 hours before surgery - this should only be a light meal.<br>    •  Do not chew gum or lollies- these count as food because they cause the stomach to produce extra acid.<br>    •  Adult patients can have clear fluids until 2 hours before surgery. This should be no more than 2 cups or 400mls. <br>    •  Ask when you should fast from.",
            "<h4>Wellness</h4><p>The whole point of surgery is to help you get well. So it makes sense that you might not feel like turning somersaults in the weeks before your procedure. Nevertheless, do try to do some light exercise every day. It'll help you recover faster after surgery.</p><p>It's also important to be clean. Having a bath or shower before coming in reduces the risk of infection during your procedure.</p><p>If you are unwell within 3 days before your surgery you will need to call the hospital or contact your local doctor for advice. If you are too unwell for surgery, it may be postponed until you are feeling better and it is safer for you to have an anaesthetic. </p><p>If you have any of the following please call us: </p>    •  Temperature or fever- feeling hot or cold 	<br>    •  Sore throat 	<br>    •  Rash or swelling 	<br>    •  Feel unwell 	<br>    •  A cut, break or tear in your skin 	<br>    •  Any infected wounds 	<br>    •  Diarrhoea or vomiting 	<br>    •  A recent unplanned visit to the Emergency Department or local doctor",
            "<h4>Who will be at home</h4><p>If you are cleared to go home, you must have someone stay with you the night after your surgery.</p><p>If you have had a General Anaesthetic or sedation you will need to have a responsible adult take you home and stay overnight with you. This is for your own safety as you may be lightheaded and drowsy. Your ability to do tasks may be affected. A small amount of anaesthetic may still be in your body.</p><p>You must not drive home after surgery. It is not safe.</p><p>If you don't have a family member or friend able to pick you up and stay with you please tell the hospital staff. We want you to have your surgery but we also want you to be safe afterwards. </p>",
            "<h4>What to bring</h4><p>Almost everything you need for your hospital stay will be supplied for you. If you are staying overnight, all you need to bring is a single small bag with toiletries, the medicine you are taking and pyjamas.</p><p>Bring to hospital:</p>    •  Two (2) pairs of clean pyjamas/nighties (labelled with your name).	<br>    •  Dressing gown and slippers (non-slip sole)	<br>    •  Toiletries (soap, toothpaste, toothbrush, hairbrush/comb, razor, tissues) 	<br>    •  Small amount of money under $10 (for phone or newspaper) <br>    •  Current medicines (these will be returned to you when you go home) and a list of ALL of your medicines	<br>    •  Comfortable clean day clothing	<br>    •  Glasses, hearing aids and non-electric walking aids (labelled with your name)	<br>    •  Any letters from your doctors	<br>    •  All relevant x-rays, scans and blood test results	<br>    •  Medicare card and (if applicable) private health insurance fund card/book, veterans affairs repat card, details of workers compensation, public liability or third party case<p>Theft does occur in hospitals.</p><p>Do NOT bring to hospital:</p>	<br>    •  Valuables (any jewellery or large amounts of money over $10) 	<br>    •  Radios without headphones	<br>    •  Mobile phones (they can get lost or become a target for thieves)	<br>    •  Electrical appliances (including electric shavers)	<br>    •  Pot plants or flowers	<br>    •  Large bags or excessive clothing- bring only the bare minimum	<br>    •  Alcohol or illegal drugs	<br>    •  Video games",
            "<h4>Getting to Hospital</h4><p>We understand that sometimes people run late, but running too late could mean that your surgery is postponed.</p><p>Hospitals are complex and busy places. Sometimes just finding the right entrance can be tricky.</p><p>The hospital will tell you which entrance to use and where it is.</p><p>Hospital car parks are busy too. So leave plenty of time to drive to hospital and some extra time to find a park.</p><p>If you're unsure, consider taking a taxi or getting a lift.</p><p><strong>Wollongong Hospital</strong></p><p>The Main Entrance with a space for patient drop off is via Loftus Street, Wollongong.</p><p>There are two ways to get into the car park off Dudley Street. </p><p>There are also two ways to get into the car park off New Dapto Road.</p><p>There is a fee to park with the price displayed at the entrance. Disabled and concession parking up to 3 hours is free - check at the entry and at the ticket machine on Level 4 for more information.</p><p>Very little free parking is available on the streets around Wollongong hospital. Please check the signposts as there are strict time limits.</p>",
            "<h4>Getting to Hospital</h4><p>We understand that sometimes people run late, but running too late could mean that your surgery is postponed.</p><p>Hospitals are complex and busy places. Sometimes just finding the right entrance can be tricky.</p><p>The hospital will tell you which entrance to use and where it is.</p><p>Hospital car parks are busy too. So leave plenty of time to drive to hospital and some extra time to find a park.</p><p>If you're unsure, consider taking a taxi or getting a lift.</p><p><strong>Shellharbour Hospital</strong></p><p>The Main Entrance with a space for patient drop off is via 15-17 Madigan Boulevard, Mount Warrigal. </p><p>You can access the hospital car park via Madigan Boulevard, Mount Warrigal.</p><p>Disabled parking is available.</p><p>Some parking is available on the streets around the hospital. Please check the signposts as there may be time limits.</p>",
            "<h4>Getting to Hospital</h4><p>We understand that sometimes people run late, but running too late could mean that your surgery is postponed.</p><p>Hospitals are complex and busy places. Sometimes just finding the right entrance can be tricky.</p><p>The hospital will tell you which entrance to use and where it is.</p><p>Hospital car parks are busy too. So leave plenty of time to drive to hospital and some extra time to find a park.</p><p>If you're unsure, consider taking a taxi or getting a lift.</p><p><strong>Shoalhaven Hospital</strong></p><p>The Main Entrance with a space for patient drop off is via Scenic Drive, Nowra.</p><p>You can access the hospital car park via Scenic Drive.</p><p>Disabled parking is available. </p><p>Some parking is available on the streets around the hospital. Please check the signposts as there are time limits.</p>"};

    //    private VideoView videoview_movies;
//    private int position = 0;
//    private MediaController mediaController;
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
        ivPlay = (ImageView) findViewById(R.id.ivPlay);
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
        tvDetails.setText((Html.fromHtml(arrVideos[position])));

        int id = this.getRawResIdByName("myvideo");
        Videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
        Videoview.start();
        ln_video.setVisibility(View.GONE);
        QTSHelp.setLayoutView(ivPause,QTSHelp.GetWidthDevice(this)/5,QTSHelp.GetWidthDevice(this)/5);
        QTSHelp.setLayoutView(ivPlay,QTSHelp.GetWidthDevice(this)/5,QTSHelp.GetWidthDevice(this)/5);

        Videoview.setDimensions(displayWidth, displayHeight*2/5);
        Videoview.getHolder().setFixedSize(displayWidth, displayHeight*2/5);
        Videoview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    ivPlay.setVisibility(View.VISIBLE);
                    ivPause.setVisibility(View.GONE);
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

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Videoview.pause();
                ivPlay.setVisibility(View.GONE);
                ivPause.setVisibility(View.VISIBLE);
            }
        });

        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Videoview.start();
                ln_video.setVisibility(View.GONE);
            }
        });

        img_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ln_video.setVisibility(View.GONE);
                Videoview.start();
                if (a==0) {
                    AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                    amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                    amanager.setStreamMute(AudioManager.STREAM_RING, true);
                    amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
                    a = 1;
                }else if(a==1) {
                    AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                    amanager.setStreamMute(AudioManager.STREAM_RING, false);
                    amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
                    a=0;
                }

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
                if (b==0) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    Videoview.start();
                    ln_video.setVisibility(View.GONE);
                    b=1;
                }else if (b==1){
                    Videoview.start();
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    ln_video.setVisibility(View.GONE);
                    b=0;
                }
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Videoview.setDimensions(displayHeight, displayWidth);
            Videoview.getHolder().setFixedSize(displayHeight, displayWidth);
            toolbar.setVisibility(View.GONE);
        }else{
            toolbar.setVisibility(View.VISIBLE);
            Videoview.setDimensions(displayWidth, displayHeight*2/5);
            Videoview.getHolder().setFixedSize(displayWidth, displayHeight*2/5);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Videoview.suspend();
    }

    @Override
    public void onResume() {
        super.onResume();
        Videoview.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Videoview.stopPlayback();
    }

//        videoview_movies = (VideoView) findViewById(R.id.videoview_movies);
//
//        // Set the media controller buttons
//        if (mediaController == null) {
//            mediaController = new MediaController(ActShowMovies.this);
//
//
//            // Set the videoView that acts as the anchor for the MediaController.
//            mediaController.setAnchorView(videoview_movies);
//
//
//            // Set MediaController for VideoView
//            videoview_movies.setMediaController(mediaController);
//            String videoUrl="http://www.youtubemaza.com/files/data/366/Tom%20And%20Jerry%20055%20Casanova%20Cat%20(1951).mp4";
//            Uri video = Uri.parse(videoUrl);
//            videoview_movies.setVideoURI(video);
//        }
//
//
//        try {
////            String videoUrl="http://www.youtubemaza.com/files/data/366/Tom%20And%20Jerry%20055%20Casanova%20Cat%20(1951).mp4";
////            Uri video = Uri.parse(videoUrl);
////            videoview_movies.setVideoURI(video);
//            // ID of video file.
//            int id = this.getRawResIdByName("myvideo");
//            videoview_movies.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
//
//        } catch (Exception e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }
//
//        videoview_movies.requestFocus();
//
//
//        // When the video file ready for playback.
//        videoview_movies.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//
//            public void onPrepared(MediaPlayer mediaPlayer) {
//
//
//                videoview_movies.seekTo(position);
//                if (position == 0) {
//                    videoview_movies.start();
//                }
//
//                // When video Screen change size.
//                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
//                    @Override
//                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
//
//                        // Re-Set the videoView that acts as the anchor for the MediaController
//                        mediaController.setAnchorView(videoview_movies);
//                    }
//                });
//            }
//        });
//
//    }
//
//    // Find ID corresponding to the name of the resource (in the directory raw).
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
//
//
//    // When you change direction of phone, this method will be called.
//    // It store the state of video (Current position)
//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//
//        // Store current position.
//        savedInstanceState.putInt("CurrentPosition", videoview_movies.getCurrentPosition());
//        videoview_movies.pause();
//    }
//
//
//    // After rotating the phone. This method is called.
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // Get saved position.
//        position = savedInstanceState.getInt("CurrentPosition");
//        videoview_movies.seekTo(position);

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Toast.makeText(this, "Volume Down Pressed", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Toast.makeText(this, "Volume Up Pressed", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }

        else {
            return super.onKeyDown(keyCode, event);
        }
    }
}

