package com.company.qts.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.qts.demo1.R;

/**
 * Created by rufflez on 6/20/15.
 */
public class FloatingLabelsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.floating_labels, container, false);
        return rootView;
    }
}
