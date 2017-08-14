package com.company.qts.hei;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.demo1.R;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActHEIDrink extends AppCompatActivity {
    private ListView lv_drink;
    private TextView tv_drink,tv_seach;
    private ImageView img_arrow;
    private APIService mAPIService;
    private String idspirits;
    private AdapterDrink adapter;
    private EditText edt_seach;
    private List<Drink> arrlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_heidrink);
        initUI();

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent i = getIntent();
        tv_drink.setText(i.getStringExtra("namespirits"));
        int spirits_id = i.getIntExtra("spirits_id",12);
        idspirits = String.valueOf(spirits_id);

        mAPIService = APIUtils.getAPIService();
        mAPIService.postHEIDrink("f92e4c43791449f2a90646bd5d09bd60",idspirits).enqueue(new Callback<PostHEIDrink>() {
            @Override
            public void onResponse(Call<PostHEIDrink> call, Response<PostHEIDrink> response) {
                adapter = new AdapterDrink(ActHEIDrink.this,response.body().getDrinks());
                lv_drink.setAdapter(adapter);
                arrlist = response.body().getDrinks();
            }

            @Override
            public void onFailure(Call<PostHEIDrink> call, Throwable t) {
                QTSHelp.ShowpopupMessage(ActHEIDrink.this,"error");
            }
        });

        tv_seach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_seach.setVisibility(View.GONE);
                edt_seach.setVisibility(View.VISIBLE);
            }
        });

        edt_seach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new SearchTask().execute(s.toString().trim().toLowerCase());
//                System.out.println("Text ["+s+"] - Start ["+start+"] - Before ["+before+"] - Count ["+count+"]");
//                if (count < before) {
//                    // We're deleting char so we need to reset the adapter data
//                    adapter.resetData();
//                }
//                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        lv_drink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink drink = (Drink) adapter.getItem(position);
                String h = drink.getId();
                QTSHelp.showToast(ActHEIDrink.this,""+h);
                String b = drink.getName().toString();
                String c = drink.getDescription().toString();
                String e = drink.getId().toString();
                int f = position;
                String d = idspirits;
                String a = drink.getImage().toString();
                Intent i = new Intent(ActHEIDrink.this,ActHEIInfo.class);
                i.putExtra("name",b);
                i.putExtra("img",a);
                i.putExtra("info",c);
                i.putExtra("id",d);
                i.putExtra("position",f);
                i.putExtra("idmixologits",e);
                startActivity(i);
            }
        });
    }

    private void initUI() {
        edt_seach = (EditText) findViewById(R.id.edt_seach);
        lv_drink = (ListView) findViewById(R.id.lv_drink);
        tv_drink = (TextView) findViewById(R.id.tv_drink);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        tv_seach = (TextView) findViewById(R.id.tv_seach);
    }

    private class SearchTask extends AsyncTask<String, Void, List<Drink>> {

        @Override
        protected List<Drink> doInBackground(String... params) {
            // TODO Auto-generated method stub
            List<Drink> temp = new ArrayList<Drink>();
            for (int i = 0; i < arrlist.size(); i++) {
                Drink obj = arrlist.get(i);
                if (obj.getName().toLowerCase().contains(params[0]))
                    temp.add(obj);
            }
            return temp;
        }

        @Override
        protected void onPostExecute(List<Drink> result) {
            // TODO Auto-generated method stub
            adapter.setData(result);
            super.onPostExecute(result);
        }
    }
}
