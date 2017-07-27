package com.company.qts.demo1;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.Adapter.SingleCheckAdapter;
import com.company.qts.Object.LineLVBackground;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;
import java.util.List;

public class ActBackground extends AppCompatActivity implements AdapterView.OnItemClickListener {

//    private ArrayList<LineLVBackground> arrbackground = new ArrayList<>();
    ListView lv_background;
    RecyclerView rclview;
    ImageView img_arrow;
    TextView tv_save;
    int color;
    private List<LineLVBackground> mSingleCheckList = new ArrayList<>();
    private SingleCheckAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_background);

        initUI();

        dataarr();

        mAdapter = new SingleCheckAdapter(this, mSingleCheckList);
        rclview.setLayoutManager(new LinearLayoutManager(this));
        rclview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActBackground.this);
                builder.setIcon(R.drawable.img_error);
                builder.setTitle("Demo1");
                builder.setMessage("Do you agree?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        QTSHelp.setColor(ActBackground.this, color);
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    private void dataarr() {
        mSingleCheckList.add((new LineLVBackground("Blue", R.color.blue)));
        mSingleCheckList.add((new LineLVBackground("Red", R.color.red)));
        mSingleCheckList.add((new LineLVBackground("Gray", R.color.gray)));
        mSingleCheckList.add((new LineLVBackground("Green", R.color.green)));
        mSingleCheckList.add((new LineLVBackground("Black",R.color.black)));
        mSingleCheckList.add((new LineLVBackground("Cyan", R.color.cyan)));
        mSingleCheckList.add((new LineLVBackground("Dkhgray", R.color.dkgray)));
        mSingleCheckList.add((new LineLVBackground("Yellow", R.color.yellow)));
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_save = (TextView) findViewById(R.id.tv_save);
        rclview = (RecyclerView) findViewById(R.id.rclview);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
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
                        color = Color.DKGRAY;
                        break;
                    case 7:
                        color = Color.YELLOW;
                        break;
                }
    }
}