package com.company.qts.demo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.Adapter.AdapterLVSetting;
import com.company.qts.Object.LineLVSetting;

import java.util.ArrayList;

public class ActSetting extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<LineLVSetting> arrsetting = new ArrayList<>();
    ListView lv_setting;
    ImageView bt_arrow_setting;
    TextView tv_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_setting);
        initUI();

        dataarr();
        AdapterLVSetting adapterlvsetting = new AdapterLVSetting(this,arrsetting);
        lv_setting.setAdapter(adapterlvsetting);

        lv_setting.setOnItemClickListener(this);

        bt_arrow_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActSetting.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Logout setting");
                builder.setMessage("Are you sure you want to logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
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
        arrsetting.add((new LineLVSetting("My Profile")));
        arrsetting.add((new LineLVSetting("History")));
        arrsetting.add((new LineLVSetting("Documents")));
        arrsetting.add((new LineLVSetting("My Profile")));
        arrsetting.add((new LineLVSetting("History")));
        arrsetting.add((new LineLVSetting("Documents")));
        arrsetting.add((new LineLVSetting("My Profile")));
        arrsetting.add((new LineLVSetting("History")));
        arrsetting.add((new LineLVSetting("Documents")));
        arrsetting.add((new LineLVSetting("My Profile")));
        arrsetting.add((new LineLVSetting("History")));
        arrsetting.add((new LineLVSetting("Documents")));
    }

    private void initUI() {
        lv_setting = (ListView) findViewById(R.id.lv_setting);
        bt_arrow_setting = (ImageView) findViewById(R.id.bt_arrow_setting);
        tv_logout = (TextView) findViewById(R.id.tv_logout);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent inten = new Intent(ActSetting.this,ActMyProfile.class);
                startActivity(inten);
                finish();
                break;
        }
    }
}