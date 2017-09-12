package com.company.qts.demo1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

//import com.company.qts.APIGET.ActMain;
import com.company.qts.apipost.LoginActivity;
import com.company.qts.helper.QTSHelp;

public class ActHome extends AppCompatActivity {

    ImageView img_sthome;
    LinearLayout ln_home;
    private Button bt_quangnam,bt_hue,bt_danang,bt_other,bt_contacst,bt_test,bt_test2;
    private String[]name;
    private int myNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_home);

        initUI();
        name = new String[]{"Trung Quoc","Viet Nam","Lao","Nhat Ban","Thai Lan","Nga","My","Trieu Tien","An Do","Anh","Phap","Campuchia","Duc","Singapo","Philipin","Dongtimo","Mong Co","Han Quoc","Bugari","Nam Phi","Ha Lan","Cannada"};
        img_sthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActHome.this,ActSetting.class);
                startActivityForResult(intent,5);
            }
        });

        bt_quangnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActHome.this,ActQuangNam.class);
                startActivity(intent);
                overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
            }
        });

        bt_danang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://www.google.com/maps/@16.0559665,108.2116037,13.5z?hl=en-US";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        bt_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActHome.this,ActOther.class);
                startActivityForResult(intent,3);
            }
        });

        //--------------------------------------------------------------------
//        AsyncTaskDownload asyncTaskDownload = new AsyncTaskDownload();
//        asyncTaskDownload.SetLister(ActHome1.this);
//        asyncTaskDownload.execute("https://api.coinsecure.in/v1/login");
//        //https://api.myjson.com/bins/4z4r4
        //---------------------------------------------------------------------

    }

    public void initUI(){
        bt_contacst = (Button) findViewById(R.id.bt_contacst);
        bt_other = (Button) findViewById(R.id.bt_other);
        bt_danang = (Button) findViewById(R.id.bt_danang);
        bt_quangnam = (Button) findViewById(R.id.bt_quangnam);
        img_sthome = (ImageView) findViewById(R.id.img_sthome);
        ln_home = (LinearLayout) findViewById(R.id.ln_home);
        bt_hue = (Button) findViewById(R.id.bt_hue);
        bt_test = (Button) findViewById(R.id.bt_test);
        bt_test2 = (Button) findViewById(R.id.bt_test2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.onStop();
        ln_home.setBackgroundColor(QTSHelp.getColor(this));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == 5) {

            if(resultCode == Activity.RESULT_OK) {
                final String result = data.getStringExtra(ActSetting.EXTRA_DATA);
                Toast.makeText(this,result,Toast.LENGTH_LONG).show();
            } else {
            }
        }
        if (requestCode ==3){
            if (resultCode == Activity.RESULT_OK){
                final String result1 = data.getStringExtra(ActSetting.EXTRA_DATA);
                myNum = Integer.parseInt(result1);
                bt_other.setText(name[myNum]);

            }
        }
        bt_contacst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActHome.this,ActContacts.class);
                startActivity(intent);
            }
        });
        bt_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ActHome1.this, ActMain.class);
//                startActivity(intent);
            }
        });
        bt_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActHome.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToSo (View view) {
        goToUrl ( "https://www.thuathienhue.gov.vn/vi-vn/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

//    @Override
//    public void OnFinisheDownload(String result) {
//        Log.i("hehe", result);
//        ParseJson(result);
//    }

//    public void ParseJson(String jsonString) {
//        try {
//
////            JSONObject jsonRootObject = new JSONObject(jsonString);
////            JSONArray jsonArray = jsonRootObject.optJSONArray("Weather");
////            for (int i=0; i < jsonArray.length(); i++) {
////                JSONObject jsonObject = jsonArray.getJSONObject(i);
////                String tv_city = jsonObject.optString("cityName");
////                String tv_thoitiet = jsonObject.optString("weather");
////                String tv_nhietdo = jsonObject.optString("temperature");
////                String imgtt = jsonObject.optString("icon");
////
////                tv_1.setText(jsonRootObject.getString("success"));
//            }
//
////        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
