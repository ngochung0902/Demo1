package com.company.qts.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.object.ObjectPerson;

public class ActShowObject extends AppCompatActivity {
    private ImageView img_arrow;
    private TextView tv_showobject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_show);
        initUI();
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ObjectPerson object = (ObjectPerson) getIntent().getSerializableExtra("serialize");
        tv_showobject.setText("id: "+object.id+"\n"+"name: "+object.name+"\n"+"email: "+object.email+"\n"+"phone: "+object.phone);
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_showobject = (TextView) findViewById(R.id.tv_showobject);
    }
}
