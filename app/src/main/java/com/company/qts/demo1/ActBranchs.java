package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.company.qts.adapter.AdapterBranchs;
import com.company.qts.object.Branchs;

import java.util.ArrayList;

public class ActBranchs extends AppCompatActivity {

    private ArrayList<Branchs> arrbranchs = new ArrayList<>();
    private ListView lv_branchs;
    private ImageView img_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_branchs);

        initUI();

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dataarr();
        AdapterBranchs adapterBranchs = new AdapterBranchs(this,arrbranchs);
        lv_branchs.setAdapter(adapterBranchs);

        lv_branchs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActBranchs.this,ActLongClickLV.class);
                intent.putExtra("positon",position);
                startActivity(intent);
                return false;
            }
        });

        lv_branchs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActBranchs.this,ActonClickLV.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    private void dataarr() {
        arrbranchs.add((new Branchs(R.drawable.img_car,"Honda","Japan")));
        arrbranchs.add((new Branchs(R.drawable.img_car4,"Yamaha","Japan")));
        arrbranchs.add((new Branchs(R.drawable.img_car2,"BWM","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car3,"Audi","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car4,"Mercedes","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car,"Honda","Japan")));
        arrbranchs.add((new Branchs(R.drawable.img_car4,"Yamaha","Japan")));
        arrbranchs.add((new Branchs(R.drawable.img_car2,"BWM","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car3,"Audi","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car4,"Mercedes","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car,"Honda","Japan")));
        arrbranchs.add((new Branchs(R.drawable.img_car4,"Yamaha","Japan")));
        arrbranchs.add((new Branchs(R.drawable.img_car2,"BWM","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car3,"Audi","Germany")));
        arrbranchs.add((new Branchs(R.drawable.img_car4,"Mercedes","Germany")));
    }

    private void initUI() {
        lv_branchs = (ListView) findViewById(R.id.lv_branchs);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
    }
}
