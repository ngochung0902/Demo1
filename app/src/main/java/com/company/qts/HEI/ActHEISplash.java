package com.company.qts.hei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.company.qts.demo1.R;
import com.company.qts.helper.QTSConstrains;

public class ActHEISplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heisplash);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        // Wait given period of time or exit on touch
//                        if(QTSHelp.getIsLogin(ActHEISplash.this)) {
//                            wait(QTSConstrains.Splash_Time);
//                            Intent intent = new Intent(ActHEISplash.this, ActHome.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                        else {
                            wait(QTSConstrains.Splash_Time);
                            Intent intent = new Intent(ActHEISplash.this, ActHEILogin.class);
                            startActivity(intent);
                            finish();
//                        }
                    }
                } catch (InterruptedException ex) {

                }

            }

        };
        splashTread.start();
    }
}
