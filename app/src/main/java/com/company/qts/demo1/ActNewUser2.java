package com.company.qts.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ActNewUser2 extends AppCompatActivity {

    ImageView img_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_new_user2);
        initUI();
    }

    public void initUI(){
        img_avatar = (ImageView) findViewById(R.id.img_avatar);
    }
}
