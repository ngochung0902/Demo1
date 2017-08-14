package com.company.qts.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.company.qts.demo1.ActFragmentMain;
import com.company.qts.demo1.R;

/**
 * Created by MyPC on 14/08/2017.
 */
public class Frm3 extends Fragment {
    private EditText edt_username,edt_password;
    private OnFragmentManager listener;
    private ActFragmentMain mainactivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm3, container, false);
        edt_username = (EditText) view.findViewById(R.id.editText2);
        edt_password = (EditText) view.findViewById(R.id.editText);
        edt_username.setText("hung");
        edt_password.setText("123456");
//        listener.onDataSelected( edt_password.getText().toString()+"\n"+edt_username.getText().toString());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentManager ){
            listener = (OnFragmentManager ) context;
        } else {
        }
    }

    public interface OnFragmentManager {
        void onDataSelected(String data);
    }

    public void showRs() {

    }
}

