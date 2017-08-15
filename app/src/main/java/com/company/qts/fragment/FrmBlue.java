package com.company.qts.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.company.qts.demo1.ActListBlue;
import com.company.qts.demo1.ActSetting;
import com.company.qts.demo1.R;
import com.company.qts.helper.QTSHelp;

/**
 * Created by MyPC on 15/08/2017.
 */
public class FrmBlue extends ListFragment implements AdapterView.OnItemClickListener {

    private position po;

    public FrmBlue() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_blue, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.lv,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                po.p(1);
                break;
            case 1:
                Intent i = new Intent(getActivity(), ActListBlue.class);
                startActivityForResult(i,3);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3) {

            if(resultCode == Activity.RESULT_OK) {
                final String result = data.getStringExtra(ActSetting.EXTRA_DATA);
                QTSHelp.showToast(getActivity(),result);
            } else {
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof position ){
            po = (position ) context;
        } else {
        }
    }

    public interface position{
        void p(int a);
    }
}
