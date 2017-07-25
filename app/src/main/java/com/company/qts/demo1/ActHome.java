package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ActHome extends AppCompatActivity {

    ImageView img_sthome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_home);

        initUI();

        img_sthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActHome.this,ActSetting.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void initUI(){
        img_sthome = (ImageView) findViewById(R.id.img_sthome);
    }
}
