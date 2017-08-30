package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.adapter.AdapterLVFB;
import com.company.qts.database.SQLiteSourceFB;
import com.company.qts.object.Football;

import java.util.ArrayList;

public class ActFootball extends AppCompatActivity {
    private ImageView img_newuser,img_back;
    private ListView lv_fb;
    private TextView noitem;
    private ArrayList<Football> arr = new ArrayList<Football>();
    private SQLiteSourceFB datasource;
    private View load_more_lv;
    private boolean isLoading = false;
    private AdapterLVFB adapter;
    mHandler mHandler;
    int a=8,b,i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_football);
        i=1;
        b=8;

        img_back = (ImageView) findViewById(R.id.img_back);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        load_more_lv = inflater.inflate(R.layout.load_more_lv,null);
        mHandler = new mHandler();
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_newuser = (ImageView) findViewById(R.id.img_newuser);
        img_newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                b=8;
                Intent i = new Intent(ActFootball.this,ActNewFootball.class);
                startActivity(i);
            }
        });
        lv_fb = (ListView) findViewById(R.id.lv_fb);
        noitem = (TextView) findViewById(R.id.noitem);

        datasource = new SQLiteSourceFB(ActFootball.this);
        datasource.open();
        lv_fb.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                if (lv_fb.getCount()>=arr2.size())
//                {
//                    datasource.getAllContacts();
//                }
//                else
//                {
                    if(view.getLastVisiblePosition() == totalItemCount-1 && isLoading == false && lv_fb.getCount()>=8 && lv_fb.getCount()<datasource.getAllContacts().size() )
                    {
                        i++;
                        isLoading = true;
                        Thread thread = new ThreaData();
                        thread.start();
                    }
                }
            /*}*/
        });



//        datasource.add("20170829171527.png","1","1","5");
//        datasource.add("20170829171527.png","2","2","5");
//        datasource.add("20170829171527.png","3","3","5");
//        datasource.add("20170829171527.png","4","4","5");
//        datasource.add("20170829171527.png","5","5","5");
//        datasource.add("20170829171527.png","6","6","5");
//        datasource.add("20170829171527.png","7","7","5");
//        datasource.add("20170829171527.png","8","8","5");
//
//        datasource.add("20170829171527.png","9","9","5");
//        datasource.add("20170829171527.png","10","10","5");
//        datasource.add("20170829171527.png","11","11","5");
//        datasource.add("20170829171527.png","12","12","5");
//        datasource.add("20170829171527.png","13","13","5");
//        datasource.add("20170829171527.png","14","14","5");
//        datasource.add("20170829171527.png","15","15","5");
//        datasource.add("20170829171527.png","16","16","5");
//
//        datasource.add("20170829171527.png","17","17","5");
//        datasource.add("20170829171527.png","18","18","5");
//        datasource.add("20170829171527.png","19","19","5");
//        datasource.add("20170829171527.png","20","20","5");
//        datasource.add("20170829171527.png","21","21","5");
//        datasource.add("20170829171527.png","22","22","5");
//        datasource.add("20170829171527.png","23","23","5");
//        datasource.add("20170829171527.png","24","24","5");
//
//        datasource.add("20170829171527.png","25","25","5");
//        datasource.add("20170829171527.png","26","26","5");
//        datasource.add("20170829171527.png","27","27","5");
    }

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            // update UI - display notes on listview
            if(arr != null && arr.size() > 0)
            {
                noitem.setVisibility(View.GONE);
                lv_fb.setVisibility(View.VISIBLE);
                // view all note to listview
                adapter = new AdapterLVFB(ActFootball.this,arr);
                lv_fb.setAdapter(adapter);

            }else {
                lv_fb.setVisibility(View.GONE);
                noitem.setVisibility(View.VISIBLE);
            }
        }
    };

    private void viewAllNotes()
    {
        // create new thread to get all notes in background task
        new Thread(new Runnable() {
            @Override
            public void run() {
                // read all notes form DB
                arr = datasource.getloadmore(8,0);
                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //datasource.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        // read data from DB
        viewAllNotes();
    }

    public class mHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    lv_fb.addFooterView(load_more_lv);
                    break;
                case 1:
                    lv_fb.removeFooterView(load_more_lv);
                    adapter.AddListItemAdapter((ArrayList<Football>) msg.obj);
                    isLoading = false;
                    break;
            }
        }
    }

    public class ThreaData extends Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            ArrayList<Football> list = datasource.getloadmore(a,b);
            try {
                Thread.sleep(3000);
                b = 8 * i -1;
                a = 8;
                Log.e("dataa BBB",b+"");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1,list);
            mHandler.sendMessage(message);
        }
    }
}
