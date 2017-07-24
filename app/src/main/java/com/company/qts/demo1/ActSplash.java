package com.company.qts.demo1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.helper.QTSConstrains;
import com.company.qts.helper.QTSHelp;

public class ActSplash extends AppCompatActivity {
    private ImageView im_logo;
    private TextView tv_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_splash);
        initUI();
        customUI();
        //QTSHelp.showToast(this,"Heigh = "+QTSHelp.GetHeightDevice(this)+" width ="+QTSHelp.GetWidthDevice(this));
        QTSHelp.setLayoutView(im_logo,QTSHelp.GetWidthDevice(this)/3,QTSHelp.GetWidthDevice(this)/3);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        // Wait given period of time or exit on touch

                        wait(QTSConstrains.Splash_Time);
                        Intent intent = new Intent(ActSplash.this,ActLogin.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException ex) {

                }

            }

        };
        splashTread.start();
    }
    public void initUI(){
        im_logo = (ImageView) findViewById(R.id.iv_logo);
        tv_name = (TextView) findViewById(R.id.tv_name);
    }

    public void customUI(){
        tv_name.setTextColor(Color.RED);
        getWidthHeight();
    }
    private void getWidthHeight() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int wwidth = displaymetrics.widthPixels;
        QTSHelp.SetHeightDevice(this,height);
        QTSHelp.SetWidthDevice(this,wwidth);
    }
}
