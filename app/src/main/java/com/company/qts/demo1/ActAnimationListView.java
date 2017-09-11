package com.company.qts.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.company.qts.adapter.AdapterAnimationLV;
import com.company.qts.object.TraiCay;

import java.util.ArrayList;

public class ActAnimationListView extends AppCompatActivity {
    private ArrayList<TraiCay> arr = new ArrayList<>();
    private ListView lv_traicay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_animation_list_view);
        dataarr();
        lv_traicay = (ListView) findViewById(R.id.lv_traicay);
        AdapterAnimationLV adapter = new AdapterAnimationLV(this,arr);
        lv_traicay.setAdapter(adapter);

    }

    private void dataarr() {
        arr.add(new TraiCay(R.drawable.cam,"Cam"));
        arr.add(new TraiCay(R.drawable.lekima,"lê ki ma"));
        arr.add(new TraiCay(R.drawable.dudu,"Đu dủ"));
        arr.add(new TraiCay(R.drawable.chuoi,"Chuối"));
        arr.add(new TraiCay(R.drawable.hong,"Hồng"));
        arr.add(new TraiCay(R.drawable.chumruot,"Chùm ruột"));
        arr.add(new TraiCay(R.drawable.cam,"Cam"));
        arr.add(new TraiCay(R.drawable.lekima,"lê ki ma"));
        arr.add(new TraiCay(R.drawable.dudu,"Đu dủ"));
        arr.add(new TraiCay(R.drawable.chuoi,"Chuối"));
        arr.add(new TraiCay(R.drawable.hong,"Hồng"));
        arr.add(new TraiCay(R.drawable.chumruot,"Chùm ruột"));
        arr.add(new TraiCay(R.drawable.cam,"Cam"));
        arr.add(new TraiCay(R.drawable.lekima,"lê ki ma"));
        arr.add(new TraiCay(R.drawable.dudu,"Đu dủ"));
        arr.add(new TraiCay(R.drawable.chuoi,"Chuối"));
        arr.add(new TraiCay(R.drawable.hong,"Hồng"));
        arr.add(new TraiCay(R.drawable.chumruot,"Chùm ruột"));
        arr.add(new TraiCay(R.drawable.cam,"Cam"));
        arr.add(new TraiCay(R.drawable.lekima,"lê ki ma"));
        arr.add(new TraiCay(R.drawable.dudu,"Đu dủ"));
        arr.add(new TraiCay(R.drawable.chuoi,"Chuối"));
        arr.add(new TraiCay(R.drawable.hong,"Hồng"));
        arr.add(new TraiCay(R.drawable.chumruot,"Chùm ruột"));
    }
}
