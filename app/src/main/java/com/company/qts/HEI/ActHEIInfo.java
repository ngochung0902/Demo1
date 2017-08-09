package com.company.qts.HEI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.company.qts.demo1.R;
import com.company.qts.helper.ImageLoaderAvar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActHEIInfo extends AppCompatActivity {

    private ImageView img_info,img_arrow,img_moxologits;
    private TextView tv_drinkinfo,btnMixologist,btnInfo,tv_moxologits;
    private WebView wv,wvmoxologits;
    private ImageLoaderAvar imageLoader;
    private ScrollView scv_info,scv_moxologits;
    private APIService mAPIService;
    private String idspirits,idmixologits;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_heiinfo);
        initUI();

        btnInfo.setBackgroundResource(R.drawable.border_blue_left);

        imageLoader = new ImageLoaderAvar(ActHEIInfo.this);

        Intent intent = getIntent();
        tv_drinkinfo.setText(intent.getStringExtra("name"));
        final String a = intent.getStringExtra("info");
        String b = intent.getStringExtra("img");
        idspirits = intent.getStringExtra("id");
        idmixologits = intent.getStringExtra("idmixologits");
        position = intent.getIntExtra("position",10);

        wv.loadDataWithBaseURL("",a,"text/html", "utf-8", "");
        imageLoader.DisplayImage(b,img_info);

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMixologist.setBackgroundResource(R.drawable.border_white_right);
                btnMixologist.setTextColor(Color.BLUE);
                btnInfo.setBackgroundResource(R.drawable.border_blue_left);
                btnInfo.setTextColor(Color.WHITE);
                scv_info.setVisibility(View.VISIBLE);
                scv_moxologits.setVisibility(View.GONE);
            }
        });
        btnMixologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnInfo.setBackgroundResource(R.drawable.border_white_left);
                btnInfo.setTextColor(Color.BLUE);
                btnMixologist.setBackgroundResource(R.drawable.border_blue_right);
                btnMixologist.setTextColor(Color.WHITE);
                scv_info.setVisibility(View.GONE);
                scv_moxologits.setVisibility(View.VISIBLE);
            }
        });

        mAPIService = APIUtils.getAPIService();
        mAPIService.postMixilogist("f92e4c43791449f2a90646bd5d09bd60",idspirits,idmixologits).enqueue(new Callback<PostMixologist>() {
            @Override
            public void onResponse(Call<PostMixologist> call, Response<PostMixologist> response) {
                imageLoader.DisplayImage(response.body().getMixologists().get(position).getImage(),img_moxologits);
                tv_moxologits.setText(response.body().getMixologists().get(position).getName());
                wvmoxologits.loadDataWithBaseURL("",response.body().getMixologists().get(position).getBio(),"text/html", "utf-8", "");
            }

            @Override
            public void onFailure(Call<PostMixologist> call, Throwable t) {

            }
        });
    }

    private void initUI() {
        img_info = (ImageView) findViewById(R.id.img_info);
        btnMixologist = (TextView) findViewById(R.id.btnMixologist);
        btnInfo = (TextView) findViewById(R.id.btnInfo);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_drinkinfo = (TextView) findViewById(R.id.tv_drinkinfo);
        wv = (WebView) findViewById(R.id.wv);
        scv_info = (ScrollView) findViewById(R.id.scv_info);
        scv_moxologits = (ScrollView) findViewById(R.id.scv_mixologist);
        wvmoxologits = (WebView) findViewById(R.id.wvmoxologits);
        tv_moxologits = (TextView) findViewById(R.id.tv_moxologits);
        img_moxologits = (ImageView) findViewById(R.id.img_moxologits);
    }

}
