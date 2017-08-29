package com.company.qts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.demo1.R;
import com.company.qts.object.Football;
import com.company.qts.utili.Config;
import com.company.qts.utili.Util;

import java.util.ArrayList;

/**
 * Created by MyPC on 29/08/2017.
 */
public class AdapterLVFB extends BaseAdapter {
    private Context context;
    private ArrayList<Football> arr;

    public AdapterLVFB(Context context, ArrayList<Football> arr) {
        this.context = context;
        this.arr = arr;
    }

    public void AddListItemAdapter(ArrayList<Football> itemplus){
        arr.addAll(itemplus);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)arr.get(position).ID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View rowView = (View)inflater.inflate(R.layout.line_lvfb, parent, false);

        TextView tv_name = (TextView) rowView.findViewById(R.id.tv_name);
        TextView tv_club = (TextView) rowView.findViewById(R.id.tv_club);
        ImageView img = (ImageView) rowView.findViewById(R.id.img);
//        Util.setBitmapToImage(this, Config.FOLDER_IMAGES, image, imgAttach);

        Football model = arr.get(position);
        tv_name.setText(model.getName()+model.image+model.ID+model.club);
        tv_club.setText(model.getClub());
        Util.setBitmapToImage(context, Config.FOLDER_IMAGES, model.image, img);
        return rowView;
    }
}
