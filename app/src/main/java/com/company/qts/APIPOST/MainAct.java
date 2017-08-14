package com.company.qts.apipost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.company.qts.demo1.R;

/**
 * Created by MyPC on 07/08/2017.
 */
public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView loginInformation = (TextView)findViewById(R.id.login_email);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String fistname = intent.getStringExtra("fistname");
        String lastname = intent.getStringExtra("lastname");
        String email = intent.getStringExtra("email");
        String created = intent.getStringExtra("created");

        loginInformation.setText("id: "+id+"\n"+"fistname: "+fistname+"\n"+"lastname: "+lastname+"\n"+"email: "+email+"\n"+"created: "+created);
    }

}
