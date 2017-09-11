package com.company.qts.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActAnimationAlpha extends AppCompatActivity {
    private ImageView img_amination1,img_amination2,img_amination3,img_amination4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_animation_alpha);
        img_amination1 = (ImageView) findViewById(R.id.img_amination1);
        final Animation aminAlppha = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);

        img_amination1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(aminAlppha);
            }
        });

        img_amination2 = (ImageView) findViewById(R.id.img_amination2);

        final Animation aminRotate = AnimationUtils.loadAnimation(this,R.anim.anim_rotate);

        img_amination2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(aminRotate);
            }
        });

        img_amination3 = (ImageView) findViewById(R.id.img_amination3);

        final Animation aminScaleSmall = AnimationUtils.loadAnimation(this,R.anim.anim_scalesmall);

        img_amination3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(aminScaleSmall);
            }
        });

        img_amination4 = (ImageView) findViewById(R.id.img_amination4);

        final Animation aminScaleBig = AnimationUtils.loadAnimation(this,R.anim.anim_scalebig);

        img_amination4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(aminScaleBig);
            }
        });
        img_amination1.startAnimation(aminAlppha);
        img_amination2.startAnimation(aminRotate);
        img_amination3.startAnimation(aminScaleSmall);
        img_amination4.startAnimation(aminScaleBig);
    }
}
