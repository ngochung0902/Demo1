package com.company.qts.demo1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.adapter.AdapterLVSetting;
import com.company.qts.object.LineLVSetting;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;

public class ActSetting extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<LineLVSetting> arrsetting = new ArrayList<>();
    ListView lv_setting;
    ImageView bt_arrow_setting,img_tick;
    TextView tv_logout;
    public static final String EXTRA_DATA = "EXTRA_DATA";

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
                AlertDialog.Builder builder = new AlertDialog.Builder(ActSetting.this);
                builder.setIcon(R.drawable.img_error);
                builder.setTitle("Demo1");
                builder.setMessage("Are you sure you want to logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        QTSHelp.setIsLogin(ActSetting.this,false);
                        Intent intent = new Intent(ActSetting.this, ActLogin.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
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

        img_tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent();

                // Add the required data to be returned to the MainActivity
                intent.putExtra(EXTRA_DATA, "data Activity ActSetting!");

                // Set the resultCode as Activity.RESULT_OK to
                // indicate a success and attach the Intent
                // which contains our result data
                setResult(Activity.RESULT_OK, intent);

                // With finish() we close the DetailActivity to
                // return back to MainActivity
                finish();
            }
        });
    }

    private void dataarr() {
        arrsetting.add((new LineLVSetting("My Profile")));
        arrsetting.add((new LineLVSetting("Background")));
        arrsetting.add((new LineLVSetting("Documents")));
        arrsetting.add((new LineLVSetting("History")));
        arrsetting.add((new LineLVSetting("Custom Profile")));
        arrsetting.add((new LineLVSetting("Branchs")));
        arrsetting.add((new LineLVSetting("Story")));
        arrsetting.add((new LineLVSetting("Picasso")));
        arrsetting.add((new LineLVSetting("Serializable")));
        arrsetting.add((new LineLVSetting("Fragment")));
        arrsetting.add((new LineLVSetting("TabHost1")));
        arrsetting.add((new LineLVSetting("TabHost2")));
        arrsetting.add((new LineLVSetting("TabHost3")));
        arrsetting.add((new LineLVSetting("SliderMenu")));

        arrsetting.add((new LineLVSetting("Documents")));
        arrsetting.add((new LineLVSetting("History")));
        arrsetting.add((new LineLVSetting("Documents")));
        arrsetting.add((new LineLVSetting("History")));
        arrsetting.add((new LineLVSetting("Documents")));
        arrsetting.add((new LineLVSetting("History")));
    }

    private void initUI() {
        lv_setting = (ListView) findViewById(R.id.lv_setting);
        bt_arrow_setting = (ImageView) findViewById(R.id.bt_arrow_setting);
        tv_logout = (TextView) findViewById(R.id.tv_logout);
        img_tick = (ImageView)findViewById(R.id.img_tick);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent = new Intent(ActSetting.this,ActMyProfile.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(ActSetting.this,ActBackground.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(ActSetting.this,ActDocuments.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(ActSetting.this,ActHistory.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(ActSetting.this,ActCustomProfile.class);
                startActivity(intent4);
                break;
            case 5:
                Intent intent5 = new Intent(ActSetting.this,ActBranchs.class);
                startActivity(intent5);
                break;
            case 6:
                Intent intent6 = new Intent(ActSetting.this,ActStory.class);
                startActivity(intent6);
                break;
            case 7:
                Intent intent7 = new Intent(ActSetting.this,ActPicasso.class);
                startActivity(intent7);
                break;
            case 8:
                Intent intent8 = new Intent(ActSetting.this,ActSerializable.class);
                startActivity(intent8);
                break;
            case 9:
                Intent intent9 = new Intent(ActSetting.this,ActShowFrm.class);
                startActivity(intent9);
                break;
            case 10:
                Intent intent10 = new Intent(ActSetting.this,ActTabHost.class);
                startActivity(intent10);
                break;
            case 11:
                Intent intent11 = new Intent(ActSetting.this,ActTabHost2.class);
                startActivity(intent11);
                break;
            case 12:
                Intent intent12 = new Intent(ActSetting.this,ActTabHost3.class);
                startActivity(intent12);
                break;
            case 13:
                Intent intent13 = new Intent(ActSetting.this,ActSiderMenu.class);
                startActivity(intent13);
                break;
            case 14:
//                Intent intent14 = new Intent(ActSetting.this,ActSiderMenu2.class);
//                startActivity(intent14);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
//        Intent setIntent = new Intent(Intent.ACTION_MAIN);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(setIntent);
    }
}
