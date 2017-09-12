package com.company.qts.englishgrammar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.company.qts.demo1.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public final int NORMAL_MODE = 0;
    public final int SEARCH_MODE =1;

    private int currentMode = NORMAL_MODE;

    public static ArrayList<LessionModel> arr = new ArrayList<>();
    private ArrayList<LessionModel> arrSearch = new ArrayList<>();
    private ListView lstLession;
    private LessionAdapter adapter;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // inital data
        initialData();

        // find views
        lstLession = (ListView) findViewById(R.id.lst_lession);
        adapter = new LessionAdapter(this, arr);
        lstLession.setAdapter(adapter);

        edtSearch = (EditText) findViewById(R.id.edt_search);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchLession(edtSearch.getText().toString());
            }
        });

        // handle event
        lstLession.setOnItemClickListener(this);
    }
    private void searchLession(String input)
    {
        if(input.trim().length() > 0)
        {
            // search
            // clear arrSearch
            arrSearch.clear();
            // search proper item
            for(int i=0; i<arr.size(); i++)
            {
                if(arr.get(i).lessionName.trim().toLowerCase().contains(input.trim().toLowerCase()))
                {
                    arrSearch.add(arr.get(i));
                }
            }
            // change mode view
            currentMode = SEARCH_MODE;
            // update UI
            adapter = new LessionAdapter(this, arrSearch);
            lstLession.setAdapter(adapter);
        }else
        {
            // show normal listview
            // change mode view
            currentMode = NORMAL_MODE;
            // update UI
            adapter = new LessionAdapter(this, arr);
            lstLession.setAdapter(adapter);
        }
    }
    private void initialData()
    {
        arr.add(new LessionModel(0,R.drawable.flowerpica,"About"));
        arr.add(new LessionModel(1,R.drawable.flowerpica, "Asking questions 1"));
        arr.add(new LessionModel(2,R.drawable.img_f, "Asking questions 2"));
        arr.add(new LessionModel(3,R.drawable.img_o, "Can have and could have"));
        arr.add(new LessionModel(4,R.drawable.img_o,"Can"));
        arr.add(new LessionModel(5,R.drawable.ic_english, "Could"));
        arr.add(new LessionModel(6,R.drawable.ic_english,"For"));
        arr.add(new LessionModel(7,R.drawable.ic_english,"For 2"));
        arr.add(new LessionModel(8,R.drawable.ic_english,"Going to or will"));
        arr.add(new LessionModel(9,R.drawable.ic_english,"Had better"));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, LessionDetail.class);
        if(currentMode == NORMAL_MODE)
        {
            intent.putExtra("lession_id", arr.get(position).id);
        }else
        {
            intent.putExtra("lession_id", arrSearch.get(position).id);
        }
        startActivity(intent);
    }
}
