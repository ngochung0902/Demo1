package com.company.qts.hei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.company.qts.demo1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 09/08/2017.
 */
public class AdapterDrink extends BaseAdapter implements Filterable {

    Context context;
    List<Drink> postList;
    List<Drink> postList2;
    private Filter planetFilter;

    public AdapterDrink(Context context, List<Drink> postList) {
        this.context = context;
        this.postList = postList;
        this.postList2 = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  position;
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

//    @Override public Object getItem(int location) { return modelItems.get(location); }

    @Override
    public Filter getFilter() {
        if (planetFilter == null)
            planetFilter = new PlanetFilter();

        return planetFilter;
    }



    private class PlanetFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = postList2;
                results.count = postList2.size();
            }
            else {
                // We perform filtering operation
                List<Drink> nPlanetList = new ArrayList<Drink>();

                for (Drink p : postList) {
                    if (p.getName().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                        nPlanetList.add(p);
                }

                results.values = nPlanetList;
                results.count = nPlanetList.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      Filter.FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                postList = (List<Drink>) results.values;
                notifyDataSetChanged();
            }

        }
    }

    public void resetData() {
        postList = postList2;
    }
}
