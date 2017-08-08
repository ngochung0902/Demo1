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
 * Created by MyPC on 08/08/2017.
 */
public class AdapterSpirits extends BaseAdapter {

    List<Spirit> postList;
    Context context;

    public AdapterSpirits(List<Spirit> postList, Context context) {
        this.postList = postList;
        this.context = context;
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

    public static class ViewHoler{
        public ImageView img_spirits;
        public TextView tv_spirits;

        public ViewHoler(View rootView) {
            this.img_spirits = (ImageView) rootView.findViewById(R.id.img_spirits);
            this.tv_spirits = (TextView) rootView.findViewById(R.id.tv_spirits);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_hei_lvspirits, null, false);
        ViewHoler holder = new ViewHoler(convertView);
        holder.tv_spirits.setText(postList.get(position).getName());
        Glide.with(context).load(postList.get(position).getImage())
                .error(R.mipmap.ic_launcher)
                .crossFade(2000)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.img_spirits);
        return convertView;
    }
}
