package com.company.qts.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.qts.demo1.R;

/**
 * Created by MyPC on 15/08/2017.
 */
public class FrmRed extends Fragment {

    public FrmRed() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_red, container, false);
        return view;
    }
}
