package com.company.qts.clonePalfed.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.company.qts.demo1.R;
import com.company.qts.helper.QTSHelp;

public class ActNoInternet extends AppCompatActivity {
    private ImageView img_refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_no_internet);
        initUI();
        img_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QTSHelp.checkInternet(ActNoInternet.this)==true)
                {
                    finish();
                }
            }
        });
    }

    private void initUI() {
        img_refresh = (ImageView) findViewById(R.id.img_refresh);
    }

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
    }
}
