package com.company.qts.APIGET;

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
 * Created by MyPC on 04/08/2017.
 */
public class PostAdapter extends BaseAdapter {
    List<Post> postList;
    Context context;

    public PostAdapter(Context context, List<Post> postList) {
        this.postList = postList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_list_post, null, false);
        ViewHolder holder = new ViewHolder(view);
        holder.tvTitle.setText(postList.get(i).getTitle());
        holder.tvCategory.setText(postList.get(i).getName_ca());
        Glide.with(context).load(postList.get(i).getImage())
                .error(R.mipmap.ic_launcher)
                .crossFade(3000)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.imgThumbnail);
        return view;
    }

    public static class ViewHolder {
//        public View rootView;
        public ImageView imgThumbnail;
        public TextView tvTitle;
        public TextView tvCategory;

        public ViewHolder(View rootView) {
//            this.rootView = rootView;
            this.imgThumbnail = (ImageView) rootView.findViewById(R.id.imgThumbnail);
            this.tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
            this.tvCategory = (TextView) rootView.findViewById(R.id.tvCategory);
        }

    }
}
