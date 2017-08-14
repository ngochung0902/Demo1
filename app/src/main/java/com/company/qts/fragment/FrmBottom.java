package com.company.qts.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.company.qts.demo1.R;

/**
 * Created by MyPC on 14/08/2017.
 */
public class FrmBottom extends Fragment {
    private TextView tv_top,tv_bottom;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_bottom, container, false);
        tv_top = (TextView) view.findViewById(R.id.tv_top);
        tv_bottom = (TextView) view.findViewById(R.id.tv_bottom);
        return view;
    }

    public void showText(String topImageText, String bottomImageText) {
        tv_top.setText(topImageText);
        tv_bottom.setText(bottomImageText);
    }
}
