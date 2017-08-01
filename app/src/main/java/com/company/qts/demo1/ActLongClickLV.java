package com.company.qts.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ActLongClickLV extends Activity {

    Integer[]mThumbIds;
    ImageView img_popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_branchs);

        mThumbIds=new Integer[]{R.drawable.img_car,R.drawable.img_car4,
                R.drawable.img_car2,R.drawable.img_car3,
                R.drawable.img_car4,R.drawable.img_car,R.drawable.img_car4,
                R.drawable.img_car2,R.drawable.img_car3,
                R.drawable.img_car4,R.drawable.img_car,R.drawable.img_car4,
                R.drawable.img_car2,R.drawable.img_car3,
                R.drawable.img_car4};

        img_popup = (ImageView) findViewById(R.id.img_popup);

        Intent intent = getIntent();
        int a =intent.getExtras().getInt("positon");
        img_popup = (ImageView) findViewById(R.id.img_popup);
        img_popup.setImageResource(mThumbIds[a]);
    }
}
