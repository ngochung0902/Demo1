package com.company.qts.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActAnimationTranslate extends AppCompatActivity {
    private ImageView img_moto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_amination_translate);
        img_moto = (ImageView) findViewById(R.id.img_moto);

        final Animation aminTranslate = AnimationUtils.loadAnimation(this,R.anim.anim_sequential);

        img_moto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(aminTranslate);
            }
        });
    }
}
