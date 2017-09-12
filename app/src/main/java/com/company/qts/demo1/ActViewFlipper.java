package com.company.qts.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class ActViewFlipper extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private Animation in,out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_view_flipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        in = AnimationUtils.loadAnimation(this,R.anim.anim_enter);
        out = AnimationUtils.loadAnimation(this,R.anim.anim_exit);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
    }
}
