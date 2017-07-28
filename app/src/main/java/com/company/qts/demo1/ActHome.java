package com.company.qts.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.company.qts.helper.QTSHelp;

public class ActHome extends AppCompatActivity {

    ImageView img_sthome;
    LinearLayout ln_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_home);

        initUI();

        img_sthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActHome.this,ActSetting.class);
                startActivityForResult(intent,5);
            }
        });
    }

    public void initUI(){
        img_sthome = (ImageView) findViewById(R.id.img_sthome);
        ln_home = (LinearLayout) findViewById(R.id.ln_home);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ln_home.setBackgroundColor(QTSHelp.getColor(this));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == 5) {

            if(resultCode == Activity.RESULT_OK) {
                final String result = data.getStringExtra(ActSetting.EXTRA_DATA);
                Toast.makeText(this,result,Toast.LENGTH_LONG).show();
            } else {
            }
        }
    }
}
