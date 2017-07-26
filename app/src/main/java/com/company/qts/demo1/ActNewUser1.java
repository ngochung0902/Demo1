package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.company.qts.helper.QTSHelp;

public class ActNewUser1 extends AppCompatActivity {

    Button bt_next1;
    EditText ed_bio;
    ImageView bt_arrow1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_new_user1);
        initUI();

        bt_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_bio.getText().toString().equals(""))
                {
                    QTSHelp.ShowpopupMessage(ActNewUser1.this,"Bio is invalid !!!");
                }
                else {
                    Intent intent = new Intent(ActNewUser1.this, ActNewUser2.class);

                    startActivity(intent);
                }
            }
        });

        bt_arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void initUI(){
        bt_next1 = (Button) findViewById(R.id.bt_next1);
        ed_bio = (EditText) findViewById(R.id.ed_bio);
        bt_arrow1 = (ImageView)findViewById(R.id.bt_arrow1);
    }

}
