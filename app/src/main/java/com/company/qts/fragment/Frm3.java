package com.company.qts.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.company.qts.demo1.ActFragmentMain;
import com.company.qts.demo1.R;

/**
 * Created by MyPC on 14/08/2017.
 */
public class Frm3 extends Fragment {
    public EditText edt_username,edt_password;
    private Button bt_apply;
    private OnFragmentManager listener;
    private showText lis;
    private ActFragmentMain mainactivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm3, container, false);
        edt_username = (EditText) view.findViewById(R.id.editText2);
        edt_password = (EditText) view.findViewById(R.id.editText);
//        lis.onData(edt_username.getText().toString()+" - "+edt_password.getText().toString());
        bt_apply = (Button) view.findViewById(R.id.bt_apply);
        bt_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActFragmentMain activity = (ActFragmentMain) getActivity();
                if(activity instanceof ActFragmentMain){
                    ActFragmentMain myactivity = (ActFragmentMain) activity;
                    myactivity.showText(edt_username.getText().toString()+" - "+edt_password.getText().toString());
                }
            }
        });
        edt_username.setText("hung");
        edt_password.setText("123456");
        listener.onDataSelected( edt_password.getText().toString()+"\n"+edt_username.getText().toString());
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

    public void showText(){
        Log.e("name","ok");
//        Log.e("nguyen","ccc"+edt_password.getText().toString());
        if (edt_password==null){
            Log.e("null","null");
        }
    }

    public interface OnFragmentManager {
        void onDataSelected(String data);
    }

    public interface showText{
        void onData(String data1);
    }
}

