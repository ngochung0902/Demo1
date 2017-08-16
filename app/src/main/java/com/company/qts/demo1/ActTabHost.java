package com.company.qts.demo1;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.company.qts.fragment.FrmBlue;
import com.company.qts.fragment.FrmGreen;
import com.company.qts.fragment.FrmRed;

public class ActTabHost extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tab_host);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        LayoutInflater inflater = getLayoutInflater();
        View tab1 = inflater.inflate(R.layout.tab1_indicator,null);
        View tab2 = inflater.inflate(R.layout.tab2_indicator,null);
        View tab3 = inflater.inflate(R.layout.tab3_indicator,null);

        mTabHost.addTab(mTabHost.newTabSpec("tab1")
                        .setIndicator(tab1),
                FrmBlue.class, null);

        mTabHost.addTab(mTabHost.newTabSpec("tab2")
                        .setIndicator(tab2),
                FrmGreen.class, null);

        mTabHost.addTab(mTabHost.newTabSpec("tab3")
                        .setIndicator(tab3),
                FrmRed.class, null);

    }
}
