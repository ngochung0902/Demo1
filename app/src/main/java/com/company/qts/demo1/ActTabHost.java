package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class ActTabHost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tab_host);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        //Khởi tạo tab hình ảnh
        TabHost.TabSpec photospec = tabHost.newTabSpec("HinhAnh");
        //Thiết lập tên tab hiển thị và icon
        photospec.setIndicator("Hình ảnh", getResources().getDrawable(R.drawable.img_o));
        //Thiết lập nôi dung cho tab này là activity HinhAnhActivity.class
        Intent photosIntent = new Intent(this, Story1.class);
        photospec.setContent(photosIntent);

        //Khởi tạo tab nghe nhạc
        TabHost.TabSpec songspec = tabHost.newTabSpec("NgheNhac");
        songspec.setIndicator("Nghe nhạc", getResources().getDrawable(R.drawable.img_t));
        Intent songsIntent = new Intent(this, Story2.class);
        songspec.setContent(songsIntent);

        //Khởi tạo tab xem phim
        TabHost.TabSpec videospec = tabHost.newTabSpec("XemPhim");
        videospec.setIndicator("Xem phim", getResources().getDrawable(R.drawable.img_th));
        Intent videosIntent = new Intent(this, Story3.class);
        videospec.setContent(videosIntent);

        //Thêm các TabSpec trên vào TabHost
        tabHost.addTab(photospec); //Thêm tab hình ảnh
        tabHost.addTab(songspec); //Thêm tab nghe nhạc
        tabHost.addTab(videospec); //Thêm tab xem phim
    }

    }
