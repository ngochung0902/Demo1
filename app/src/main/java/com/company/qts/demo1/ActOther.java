package com.company.qts.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.adapter.AdapterLVOther;
import com.company.qts.object.Other;
import com.company.qts.helper.QTSHelp;

import java.util.ArrayList;
import java.util.Locale;

public class ActOther extends AppCompatActivity {
    private ListView lv_other;
    private EditText edt_seach;
    private ArrayList<Other> arrother = new ArrayList<>();
    public static final String EXTRA_DATA = "EXTRA_DATA";
    private String[]name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_other);
        initUI();

        name = new String[]{"Trung Quoc","Viet Nam","Lao","Nhat Ban","Thai Lan","Nga","My","Trieu Tien","An Do","Anh","Phap","Campuchia","Duc","Singapo","Philipin","Dongtimo","Mong Co","Han Quoc","Bugari","Nam Phi","Ha Lan","Cannada"};

        for (int i=0;i<name.length; i++){
            Other wp = new Other(name[i]);
            arrother.add(wp);
        }


//        dataarr();
        final AdapterLVOther adapter = new AdapterLVOther(this,arrother);
        lv_other.setAdapter(adapter);
        lv_other.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent();

                // Add the required data to be returned to the MainActivity
                intent.putExtra(EXTRA_DATA, position+"");
                // Set the resultCode as Activity.RESULT_OK to
                // indicate a success and attach the Intent
                // which contains our result data
                setResult(Activity.RESULT_OK, intent);
                // With finish() we close the DetailActivity to
                // return back to MainActivity
                finish();
            }
        });

        edt_seach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, final int actionId, KeyEvent event) {
                boolean handled = true;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    handled = true;
                    QTSHelp.hideKeyboard(ActOther.this);
                }
                return handled;
            }
        });

        edt_seach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = edt_seach.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });
    }

    private void initUI() {
        lv_other = (ListView) findViewById(R.id.lv_other);
        edt_seach = (EditText) findViewById(R.id.edt_seach);
    }
}
