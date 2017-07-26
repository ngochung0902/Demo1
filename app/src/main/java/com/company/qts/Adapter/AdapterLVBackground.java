package com.company.qts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.Object.LineLVBackground;
import com.company.qts.demo1.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 26/07/2017.
 */
public class AdapterLVBackground extends BaseAdapter {

    Context context;
    ArrayList<LineLVBackground> arrayList;

    public AdapterLVBackground(Context context, ArrayList<LineLVBackground> arrayList) {
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
        convertView = inflater.inflate(R.layout.line_lv_background,null);

        LineLVBackground lineLVBackground = arrayList.get(position);

        TextView tv_viewcolor = (TextView) convertView.findViewById(R.id.tv_viewcolor);
        TextView tv_namecolor = (TextView) convertView.findViewById(R.id.tv_namecolor);
        ImageView img_nocheck = (ImageView) convertView.findViewById(R.id.img_nocheck);

        img_nocheck.setImageResource(lineLVBackground.getImg_check());
        tv_namecolor.setText(lineLVBackground.getNamecolor());
        tv_viewcolor.setBackgroundColor(lineLVBackground.getImg_colorview());
        return convertView;
    }
}
