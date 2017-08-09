package com.company.qts.HEI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.company.qts.demo1.R;

import java.util.List;

/**
 * Created by MyPC on 09/08/2017.
 */
public class AdapterDrink extends BaseAdapter {

    Context context;
    List<Drink> postList;

    public AdapterDrink(Context context, List<Drink> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder
    {
        public ImageView img_drink;
        public TextView tv_drink1,tv_drink2;

        public ViewHolder(View rootview) {
            this.img_drink = (ImageView) rootview.findViewById(R.id.img_drink);
            this.tv_drink1 = (TextView) rootview.findViewById(R.id.tv_drink1);
            this.tv_drink2 = (TextView) rootview.findViewById(R.id.tv_drink2);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_hei_name_lv, null, false);
        ViewHolder holder = new ViewHolder(convertView);
        holder.tv_drink1.setText(postList.get(position).getName());
        holder.tv_drink2.setText(postList.get(position).getMixName());
        Glide.with(context).load(postList.get(position).getImage())
                .error(R.mipmap.ic_launcher)
                .crossFade(2000)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.img_drink);
        return convertView;
    }

    public void setData(List<Drink> arrList) {
        this.postList = arrList;
        this.notifyDataSetChanged();
    }
}
