package com.company.qts.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.company.qts.adapter.AdapterExpdbLv;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActHistory extends AppCompatActivity {
    private ExpandableListView expbLV_history;
    private List<String> listdataLevel;
    private HashMap<String,List<String>> listdataClass;
    private AdapterExpdbLv adapterExpdbLv;
    private ImageView img_arrow,img_minus,img_plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_history);
        initUI();

        adapterExpdbLv = new AdapterExpdbLv(ActHistory.this,listdataLevel,listdataClass);
        expbLV_history.setAdapter(adapterExpdbLv);

        Click_level();
        Click_class();
        Click_open();
        Click_close();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        //set arrow up and dow for expandbleListView
        expbLV_history.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = adapterExpdbLv.getGroupCount();
                for ( int i = 0; i < count; i++ )
                    expbLV_history.expandGroup(i);
                img_minus.setVisibility(View.GONE);
                img_plus.setVisibility(View.VISIBLE);
            }
        });
        img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = adapterExpdbLv.getGroupCount();
                for ( int i = 0; i < count; i++ )
                    expbLV_history.collapseGroup(i);
                img_plus.setVisibility(View.GONE);
                img_minus.setVisibility(View.VISIBLE);
            }
        });
    }

    private void Click_close() {
        expbLV_history.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                QTSHelp.showToast(ActHistory.this,listdataLevel.get(groupPosition)+" Close");
            }
        });
    }

    private void Click_open() {
        expbLV_history.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                QTSHelp.showToast(ActHistory.this,listdataLevel.get(groupPosition)+" Open");
            }
        });
    }

    private void Click_class() {
        expbLV_history.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ActHistory.this,listdataClass.get (listdataLevel.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void Click_level() {
        expbLV_history.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                QTSHelp.showToast(ActHistory.this,listdataLevel.get(groupPosition));
                return false;
            }
        });
    }

    private void initUI() {
        img_plus = (ImageView) findViewById(R.id.img_plus);
        img_minus = (ImageView) findViewById(R.id.img_minus);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        expbLV_history = (ExpandableListView) findViewById(R.id.expbLV_history);
        listdataLevel = new ArrayList<>();
        listdataClass = new HashMap<String,List<String>>();

        listdataLevel.add("Level 1");
        listdataLevel.add("Level 2");
        listdataLevel.add("Level 3");
        listdataLevel.add("College");

        List<String> Level1 = new ArrayList<String>();
        Level1.add("Class 1");
        Level1.add("Class 2");
        Level1.add("Class 3");
        Level1.add("Class 4");
        Level1.add("Class 5");

        List<String> Level2 = new ArrayList<String>();
        Level2.add("Class 6");
        Level2.add("Class 7");
        Level2.add("Class 8");
        Level2.add("Class 9");

        List<String> Level3 = new ArrayList<String>();
        Level3.add("Class 10");
        Level3.add("Class 11");
        Level3.add("Class 12");

        List<String> College = new ArrayList<String>();
        College.add("Class 14T1");
        College.add("Class 14T1");
        College.add("Class 14T1");

        listdataClass.put(listdataLevel.get(0),Level1);
        listdataClass.put(listdataLevel.get(1),Level2);
        listdataClass.put(listdataLevel.get(2),Level3);
        listdataClass.put(listdataLevel.get(3),College);
    }

    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
}
