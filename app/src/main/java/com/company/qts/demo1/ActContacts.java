package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.Adapter.AdapterContacts;
import com.company.qts.Database.SQLiteSource;
import com.company.qts.Object.Contacts;

import java.util.ArrayList;

public class ActContacts extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ImageView img_arrow,img_plus;
    private TextView tv_contacts;
    private ListView lv_contacts;
    private SQLiteSource datasource;
    private ArrayList<Contacts> arr = new ArrayList<>();

    private ArrayList<Contacts> arra = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_contacts);
        initUI();
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActContacts.this,ActNewContacts.class);
                startActivity(intent);
            }
        });
        datasource = new SQLiteSource(this);
        datasource.open();

        viewAllNotes();

        // create adapter
        AdapterContacts adapter = new AdapterContacts(this, arr);
        lv_contacts.setAdapter(adapter);
        lv_contacts.setOnItemClickListener(this);
    }

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            // update UI - display notes on listview
            if(arr != null && arr.size() > 0)
            {
                tv_contacts.setVisibility(View.GONE);
                lv_contacts.setVisibility(View.VISIBLE);
                // view all note to listview
                AdapterContacts adapter = new AdapterContacts(ActContacts.this,arr);
                lv_contacts.setAdapter(adapter);

            }else {
                lv_contacts.setVisibility(View.GONE);
                tv_contacts.setVisibility(View.VISIBLE);
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
                arr = datasource.getAllContacts();
                handler.sendEmptyMessage(0);
            }
        }).start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        datasource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // read data from DB
        viewAllNotes();
    }

    private void initUI() {
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        img_plus = (ImageView) findViewById(R.id.img_plus);
        tv_contacts = (TextView) findViewById(R.id.tv_contacts);
        lv_contacts = (ListView) findViewById(R.id.lv_contacts);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ActViewContacts.class);
        intent.putExtra("id", arr.get(position).Id);
        intent.putExtra("fistname", arr.get(position).fistname);
        intent.putExtra("lastname", arr.get(position).lastname);
        intent.putExtra("birthday", arr.get(position).birthday);
        intent.putExtra("number", arr.get(position).number);

        startActivity(intent);
    }
}
