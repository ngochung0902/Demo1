package com.company.qts.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ActMyProfile extends AppCompatActivity {
    ImageView bt_arrow_myprofile;
    EditText edt_mp_username,edt_mp_phonenumber;
    TextView tv_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_my_profile);

        initUI();

        bt_arrow_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent inten = getIntent();
        String username = inten.getStringExtra("username");
        String phonenumber = inten.getStringExtra("phonenumber");
        edt_mp_phonenumber.setText(phonenumber);
        edt_mp_username.setText(username);

    }

    private void initUI() {
        bt_arrow_myprofile = (ImageView) findViewById(R.id.bt_arrow_myprofile);
        edt_mp_username = (EditText) findViewById(R.id.edt_mp_username);
        edt_mp_phonenumber = (EditText) findViewById(R.id.edt_mp_phonenumber);
        tv_save = (TextView) findViewById(R.id.tv_save);

    }


}
