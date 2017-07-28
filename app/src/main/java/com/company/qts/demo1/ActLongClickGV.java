package com.company.qts.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ActLongClickGV extends Activity {

    Integer[]mThumbIds;
    ImageView img_view,img_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_long_click_gv);

        mThumbIds=new Integer[]{R.drawable.im_flower,R.drawable.img_o,
                R.drawable.img_t,R.drawable.img_th,
                R.drawable.img_f,R.drawable.img_fa,};

        Intent intent = getIntent();
        int a =intent.getExtras().getInt("positon");
        img_view = (ImageView) findViewById(R.id.img_view);
        img_view.setImageResource(mThumbIds[a]);

        img_arrow = (ImageView) findViewById(R.id.img_arrow);
//        img_arrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}
