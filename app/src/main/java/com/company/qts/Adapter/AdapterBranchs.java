package com.company.qts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.Object.Branchs;
import com.company.qts.demo1.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 01/08/2017.
 */
public class AdapterBranchs extends BaseAdapter {
    Context context;
    ArrayList<Branchs> arrayList;

    public AdapterBranchs(Context context, ArrayList<Branchs> arrayList) {
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
        convertView = inflater.inflate(R.layout.line_branchs,null);

        ImageView img_branchs = (ImageView) convertView.findViewById(R.id.img_branchs);
        TextView tv_to = (TextView) convertView.findViewById(R.id.tv_to);
        TextView tv_nho = (TextView) convertView.findViewById(R.id.tv_nho);

        Branchs branchs = arrayList.get(position);

        tv_to.setText(branchs.getTv_to());
        tv_nho.setText(branchs.getTv_nho());
        img_branchs.setImageResource(branchs.getImg_branchs());
        return convertView;
    }
}

