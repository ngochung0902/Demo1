package com.company.qts.HEI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.company.qts.demo1.R;
import com.company.qts.helper.QTSHelp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActHEISpirits extends AppCompatActivity {

    private ListView lv_spirits;
    private AdapterSpirits adapter;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heispirits);
        initUI();
        mAPIService = APIUtils.getAPIService();

        mAPIService.postSpirits("f92e4c43791449f2a90646bd5d09bd60").enqueue(new Callback<PostSpirits>() {
            @Override
            public void onResponse(Call<PostSpirits> call, Response<PostSpirits> response) {
                adapter = new AdapterSpirits(response.body().getSpirits(),ActHEISpirits.this);
                lv_spirits.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PostSpirits> call, Throwable t) {
                QTSHelp.ShowpopupMessage(ActHEISpirits.this,"error");
            }
        });
    }


    private void initUI() {
        lv_spirits = (ListView) findViewById(R.id.lv_spirits);
    }

}
