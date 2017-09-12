package com.company.qts.clonePalfed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.company.qts.demo1.R;
import com.company.qts.helper.QTSHelp;

public class ActHome1 extends AppCompatActivity {
    private ImageView swpalfed;
    private Switch sw_logo;
    private LinearLayout ln_sw1,ln_sw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_home2);
        if (QTSHelp.checkInternet(this)==false)
        {
            startActivity(new Intent(ActHome1.this,ActNoInternet.class));
        }
        initUI();
        QTSHelp.setLayoutView(swpalfed,QTSHelp.GetWidthDevice(this)/4,QTSHelp.GetWidthDevice(this)/4*143/190);
        QTSHelp.setLayoutView(sw_logo,QTSHelp.GetWidthDevice(this)/4,QTSHelp.GetWidthDevice(this)/4*143/190);
        sw_logo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw_logo.isChecked())
                {
                    ln_sw1.setVisibility(View.VISIBLE);
                    ln_sw2.setVisibility(View.GONE);
                    swpalfed.setImageResource(R.drawable.c_switch1);
                }
                else
                {
                    ln_sw1.setVisibility(View.GONE);
                    ln_sw2.setVisibility(View.VISIBLE);
                    swpalfed.setImageResource(R.drawable.c_switch2);
                }
            }
        });
        if (sw_logo.isChecked())
        {
            ln_sw1.setVisibility(View.VISIBLE);
            ln_sw2.setVisibility(View.GONE);
            swpalfed.setImageResource(R.drawable.c_switch1);
        }
        else
        {
            ln_sw1.setVisibility(View.GONE);
            ln_sw2.setVisibility(View.VISIBLE);
            swpalfed.setImageResource(R.drawable.c_switch2);
        }
    }

    private void initUI() {
        swpalfed = (ImageView) findViewById(R.id.swpalfed);
        sw_logo = (Switch) findViewById(R.id.sw_logo);
        ln_sw1 = (LinearLayout) findViewById(R.id.ln_sw1);
        ln_sw2 = (LinearLayout) findViewById(R.id.ln_sw2);
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
