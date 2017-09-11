package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActAnimation1 extends AppCompatActivity {
    private Button bt_animation1,bt_anmtalpha,bt_anmttranslate,bt_anmtlistview,bt_anmtmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_animation1);
        bt_animation1 = (Button) findViewById(R.id.bt_animation1);
        bt_anmtalpha = (Button) findViewById(R.id.bt_anmtalpha);
        bt_animation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActAnimation1.this, ActAnimation2.class));
                overridePendingTransition(R.anim.anim_slidedown, R.anim.anim_slideup);
            }
        });
        bt_anmtalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActAnimation1.this, ActAnimationAlpha.class));
            }
        });
        bt_anmttranslate = (Button) findViewById(R.id.bt_anmttranslate);
        bt_anmttranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActAnimation1.this, ActAnimationTranslate.class));
            }
        });
        bt_anmtlistview = (Button) findViewById(R.id.bt_anmtlistview);
        bt_anmtlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActAnimation1.this, ActAnimationListView.class));
            }
        });
        bt_anmtmenu = (Button) findViewById(R.id.bt_anmtmenu);
        bt_anmtmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActAnimation1.this,ActAnimationMenu.class));
            }
        });
    }

}
