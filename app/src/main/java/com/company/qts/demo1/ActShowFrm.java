package com.company.qts.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.company.qts.fragment.FrmBottom;

public class ActShowFrm extends AppCompatActivity {

    private Button bt_next,bt_next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_show_frm);
        bt_next = (Button) findViewById(R.id.bt_next);
        bt_next1 = (Button) findViewById(R.id.bt_next1);

        bt_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActShowFrm.this,ActFragmentMain.class);
                startActivity(i);
            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActShowFrm.this, ActMainFrm.class);
                startActivity(i);
            }
        });
    }

    public void showText(String toptext, String bottomtext){
        FrmBottom frmBottom
                = (FrmBottom) this.getSupportFragmentManager().findFragmentById(R.id.frm_bottom);
        frmBottom.showText(toptext,bottomtext);
    }
}
