package com.company.qts.demo1;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.company.qts.fragment.FrmBlue;
import com.company.qts.fragment.FrmGreen;
import com.company.qts.fragment.FrmRed;

public class ActTabHost3 extends AppCompatActivity {
    private FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tab_host3);
        tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        LayoutInflater inflater = getLayoutInflater();
        final View tab1 = inflater.inflate(R.layout.tab1_indicator,null);
        View tab2 = inflater.inflate(R.layout.tab2_indicator,null);
        View tab3 = inflater.inflate(R.layout.tab3_indicator,null);

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView im = (ImageView) tab1.findViewById(R.id.img_icontabhost);
                im.setImageResource(R.drawable.tab_drink2);
            }
        });

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(tab1), FrmBlue.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(tab2), FrmGreen.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(tab3), FrmRed.class, null);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                switch (tabHost.getCurrentTab()) {
                }
            }
        });
    }
}
