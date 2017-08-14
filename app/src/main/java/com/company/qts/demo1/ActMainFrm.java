package com.company.qts.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.company.qts.fragment.FrmDetail;
import com.company.qts.fragment.FrmListbook;

public class ActMainFrm extends AppCompatActivity implements FrmListbook.OnRageComicSelected {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main_frm);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root_layout, FrmListbook.newInstance(), "rageComicList")
                    .commit();
        }

    }

    @Override
    public void onRageComicSelected(int imageResId, String name, String description, String url) {
        final FrmDetail detailsFragment =
                FrmDetail.newInstance(imageResId, name, description, url);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, detailsFragment, "rageComicDetails")
                .addToBackStack(null)
                .commit();
    }
}
