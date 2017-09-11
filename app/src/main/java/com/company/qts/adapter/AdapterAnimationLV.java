package com.company.qts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.demo1.R;
import com.company.qts.object.TraiCay;

import java.util.ArrayList;

/**
 * Created by MyPC on 11/09/2017.
 */
public class AdapterAnimationLV extends BaseAdapter {
    Context context;
    ArrayList<TraiCay> arrayList;

    public AdapterAnimationLV(Context context, ArrayList<TraiCay> arrayList) {
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
        convertView = inflater.inflate(R.layout.line_animationlv,null);

        ImageView img = (ImageView) convertView.findViewById(R.id.img_animation);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_animation);

        TraiCay traiCay = arrayList.get(position);

        tv.setText(traiCay.getTv_animation());
        img.setImageResource(traiCay.getImg_animation());

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.anim_listview);
        convertView.startAnimation(animation);

        return convertView;
    }
}
