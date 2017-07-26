package com.company.qts.demo1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.Adapter.AdapterLVBackground;
import com.company.qts.Object.LineLVBackground;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;

public class ActBackground extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<LineLVBackground> arrbackground = new ArrayList<>();
    ListView lv_background;
    ImageView img_arrow;
    TextView tv_save;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_background);

        initUI();

        dataarr();
        AdapterLVBackground adapterlvbackground = new AdapterLVBackground(this,arrbackground);
        lv_background.setAdapter(adapterlvbackground);
        lv_background.setOnItemClickListener(this);

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QTSHelp.showToast(ActBackground.this,"save success!");
                QTSHelp.setColor(ActBackground.this,color);
            }
        });
    }

    private void dataarr() {
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Blue",Color.BLUE)));
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Red",Color.RED)));
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Gray",Color.GRAY)));
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Green",Color.GREEN)));
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Black",Color.BLACK)));
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Cyan",Color.CYAN)));
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Dkhgray",Color.DKGRAY)));
        arrbackground.add((new LineLVBackground(R.drawable.img_nocheck,"Yellow",Color.YELLOW)));
    }

    private void initUI() {
        lv_background = (ListView) findViewById(R.id.lv_background);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_save = (TextView) findViewById(R.id.tv_save);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                color = Color.BLUE;
                break;
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.GRAY;
                break;
            case 3:
                color = Color.GREEN;
                break;
            case 4:
                color = Color.BLACK;
                break;
            case 5:
                color = Color.CYAN;
                break;
            case 6:
                color=Color.DKGRAY;
                break;
            case 7:
                color = Color.YELLOW;
                break;
        }
    }
}
