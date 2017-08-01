package com.company.qts.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.helper.QTSHelp;

public class ActonClickLV extends AppCompatActivity {
    private ImageView img_arrow,img_onclick;
    private TextView tv_to;
    private Integer[]mThumbIds;
    private String[]namecar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acton_click_lv);
        initUI();
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mThumbIds=new Integer[]{R.drawable.img_car,R.drawable.img_car4,
                R.drawable.img_car2,R.drawable.img_car3,
                R.drawable.img_car4,R.drawable.img_car,R.drawable.img_car4,
                R.drawable.img_car2,R.drawable.img_car3,
                R.drawable.img_car4,R.drawable.img_car,R.drawable.img_car4,
                R.drawable.img_car2,R.drawable.img_car3,
                R.drawable.img_car4};

        namecar = new String[]{"Honda","Yamaha","BWM","Audi","Mercedes","Honda","Yamaha","BWM","Audi","Mercedes","Honda","Yamaha","BWM","Audi","Mercedes"};

        Intent intent = getIntent();
        int a =intent.getExtras().getInt("position");
        img_onclick.setImageResource(mThumbIds[a]);
        tv_to.setText(namecar[a]);
        QTSHelp.setLayoutView(img_onclick,QTSHelp.GetWidthDevice(this)/3,QTSHelp.GetWidthDevice(this)/3);
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_to = (TextView) findViewById(R.id.tv_to);
        img_onclick = (ImageView) findViewById(R.id.img_onclick);
    }
}
