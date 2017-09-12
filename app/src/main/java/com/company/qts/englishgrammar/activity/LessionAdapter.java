package com.company.qts.englishgrammar.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.demo1.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 12/09/2017.
 */
public class LessionAdapter extends BaseAdapter {
    private ArrayList<LessionModel> arr;
    private Context context;

    public LessionAdapter(Context context, ArrayList<LessionModel> arr)
    {
        this.context = context;
        this.arr = arr;
    }
    @Override
    public int getCount() {
        return this.arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arr.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View rowView = inflater.inflate(R.layout.lession_item, parent, false);

        TextView lblName = (TextView) rowView.findViewById(R.id.lbl_lession);
        lblName.setText(this.arr.get(position).lessionName);
        return rowView;
    }


}
