package com.company.qts.englishgrammar.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LessionDetail extends AppCompatActivity {
    private ViewPager viewPager;
    private DetailLessionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lession_detail);

        // find views
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new DetailLessionAdapter(this, MainActivity.arr);

        viewPager.setAdapter(adapter);
        // current view
        int id = getIntent().getExtras().getInt("lession_id");
        viewPager.setCurrentItem(id);
    }
}
