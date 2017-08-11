package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ActZoomImage extends AppCompatActivity {
    private ImageView img_arrow,img_zoomimage;
    private Integer[]mThumbIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_zoom_image);
        initUI();

        mThumbIds=new Integer[]{R.drawable.h, R.drawable.img_f, R.drawable.a, R.drawable.error, R.mipmap.ic_launcher, R.drawable.h, R.drawable.flowerpica,R.drawable.h,R.drawable.flowerpicasso};

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent i = getIntent();
        int a = i.getIntExtra("image",1);
        img_zoomimage.setImageResource(mThumbIds[a]);
        PhotoViewAttacher photoView = new PhotoViewAttacher(img_zoomimage);
        photoView.update();
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        img_zoomimage = (ImageView) findViewById(R.id.img_zoomimage);
    }
}
