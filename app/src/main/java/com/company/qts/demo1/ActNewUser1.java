package com.company.qts.demo1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.company.qts.helper.QTSHelp;

public class ActNewUser1 extends AppCompatActivity {

    Button bt_next1;
    EditText edt_bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_new_user1);
        initUI();

        bt_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_bio.getText().toString().equals(""))
                {
                    QTSHelp.ShowpopupMessage(ActNewUser1.this,"Bio is invalid !!!");
                }
                else {
                    Intent intent = new Intent(ActNewUser1.this, ActNewUser2.class);
                    startActivity(intent);
                }
            }
        });
    }
    @SuppressLint("WrongViewCast")
    public void initUI(){
        bt_next1 = (Button) findViewById(R.id.bt_next1);
        edt_bio = (EditText) findViewById(R.id.edt_bio);
    }

}
