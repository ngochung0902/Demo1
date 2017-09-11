package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActAnimation2 extends AppCompatActivity {
    private Button bt_animation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_animation2);
        bt_animation2 = (Button) findViewById(R.id.bt_animation2);
        bt_animation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActAnimation2.this, ActAnimation1.class));
                overridePendingTransition(R.anim.anim_slidedown, R.anim.anim_slideup);
            }
        });
    }
}
