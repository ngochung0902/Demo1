package com.company.qts.demo1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.company.qts.hei.APIService;
import com.company.qts.hei.APIUtils;
import com.company.qts.hei.AdapterDrink;
import com.company.qts.hei.Drink;
import com.company.qts.hei.PostHEIDrink;
import com.company.qts.helper.QTSHelp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActLoadMoreAPI extends AppCompatActivity {
    private ListView lv_hei;
    private AdapterDrink adapter;
    private APIService mAPIService;
    private List<Drink> arrlist;
    private List<Drink> arrlist2;
    List<Drink> arr;
    private View load_more_lv;
    private String idspirits;
    private boolean isLoading = false;
    private ImageView img_back;
    mHandler mHandler;
    int page=12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_load_more_api);
        lv_hei = (ListView) findViewById(R.id.lv_hei);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        load_more_lv = inflater.inflate(R.layout.load_more_lv,null);
        mHandler = new mHandler();

        idspirits = String.valueOf(page);
        mAPIService = APIUtils.getAPIService();
        mAPIService.postHEIDrink("f92e4c43791449f2a90646bd5d09bd60",idspirits).enqueue(new Callback<PostHEIDrink>() {
            @Override
            public void onResponse(Call<PostHEIDrink> call, Response<PostHEIDrink> response) {
                if (response !=null) {
                    QTSHelp.showToast(ActLoadMoreAPI.this,"onreponse");
                    adapter = new AdapterDrink(ActLoadMoreAPI.this, response.body().getDrinks());
                    lv_hei.setAdapter(adapter);
                    arrlist = response.body().getDrinks();
                }
            }

            @Override
            public void onFailure(Call<PostHEIDrink> call, Throwable t) {
                QTSHelp.ShowpopupMessage(ActLoadMoreAPI.this,"error");
            }
        });

        lv_hei.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (view.getLastVisiblePosition() == totalItemCount-1 && isLoading == false && lv_hei.getCount()<=60)
                {
                    isLoading = true;
                    Thread thread = new ThreaData();
                    thread.start();
                }
            }
        });
    }

    public class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case 0:
                    lv_hei.addFooterView(load_more_lv);
                    break;
                case 1:
                        lv_hei.removeFooterView(load_more_lv);
                        arrlist.addAll(arrlist2);
                        isLoading = false;
                    break;
            }
        }
    }

    public class ThreaData extends Thread{
        @Override
        public void run()
        {
            super.run();
            mHandler.sendEmptyMessage(0);
            getData(++page);
            arr = arrlist2;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                Message message = mHandler.obtainMessage(1,arrlist2);
                mHandler.sendMessage(message);
        }
    }

    public List<Drink> getData(int page)
    {
        idspirits = String.valueOf(page);
        mAPIService = APIUtils.getAPIService();
        mAPIService.postHEIDrink("f92e4c43791449f2a90646bd5d09bd60",idspirits).enqueue(new Callback<PostHEIDrink>() {
            @Override
            public void onResponse(Call<PostHEIDrink> call, Response<PostHEIDrink> response) {
                if (response !=null) {
                    arrlist2 = response.body().getDrinks();
                    //Log.e("array2",arrlist2.get(0).getId()+"\n"+arrlist2.get(0).getName()+"\n"+arrlist2.get(0).getMixName()+"\n"+arrlist2.get(0).getImage());
                }
            }

            @Override
            public void onFailure(Call<PostHEIDrink> call, Throwable t) {
                QTSHelp.ShowpopupMessage(ActLoadMoreAPI.this,"error");
            }
        });
        return arrlist2;
    }
}
