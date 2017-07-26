package com.company.qts.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.helper.QTSHelp;

public class ActMyProfile extends AppCompatActivity {
    ImageView bt_arrow_myprofile;
    EditText edt_mp_username,edt_mp_password;
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

        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mp_us = edt_mp_username.getText().toString();
                QTSHelp.setUsername(ActMyProfile.this,mp_us);
                String mp_ps = edt_mp_password.getText().toString();
                QTSHelp.setPassword(ActMyProfile.this,mp_ps);
                QTSHelp.showToast(ActMyProfile.this,"Save success");
            }
        });

        edt_mp_username.setText(QTSHelp.getUsername(this));
        edt_mp_password.setText(QTSHelp.getPassword(this));
    }

    private void initUI() {
        bt_arrow_myprofile = (ImageView) findViewById(R.id.bt_arrow_myprofile);
        edt_mp_username = (EditText) findViewById(R.id.edt_mp_username);
        edt_mp_password = (EditText) findViewById(R.id.edt_mp_password);
        tv_save = (TextView) findViewById(R.id.tv_save);
    }
}
