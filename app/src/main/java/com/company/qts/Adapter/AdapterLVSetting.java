package com.company.qts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.company.qts.object.LineLVSetting;
import com.company.qts.demo1.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 25/07/2017.
 */
public class AdapterLVSetting extends BaseAdapter {

    Context context;
    ArrayList<LineLVSetting> arrayList;

    public AdapterLVSetting(Context context, ArrayList<LineLVSetting> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.line_lv_setting,null);

        LineLVSetting lineLVSetting = arrayList.get(position);

        TextView tv_namesetting = (TextView) convertView.findViewById(R.id.tv_namesetting);

        tv_namesetting.setText(lineLVSetting.getNamesetting());
        return convertView;
    }
    }
