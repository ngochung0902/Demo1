package com.company.qts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.company.qts.Object.Other;
import com.company.qts.demo1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by MyPC on 02/08/2017.
 */
public class AdapterLVOther extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<Other> worldpopulationlist = null;
    private ArrayList<Other> arraylist;
    private int startPos;
    private int endPos;

    public AdapterLVOther(Context context, List<Other> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Other>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView tv_lineother;
    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public Other getItem(int position) {
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.line_other, null);
            // Locate the TextViews in listview_item.xml
            holder.tv_lineother = (TextView) view.findViewById(R.id.tv_lineother);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.tv_lineother.setText(worldpopulationlist.get(position).getName());

//        String country = item.getCountry().toLowerCase(Locale.getDefault());
//        if (country.contains(searchString)) {
//            Log.e("test", country + " contains: " + searchString);
//            int startPos = country.indexOf(searchString);
//            int endPos = startPos + searchString.length();
//
//            Spannable spanText = Spannable.Factory.getInstance().newSpannable(holder.country.getText()); // <- EDITED: Use the original string, as `country` has been converted to lowercase.
//            spanText.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//            holder.country.setText(spanText, TextView.BufferType.SPANNABLE);
//    }
        return view;
    }
    // Filter Class
    public void filter(String charText) {
        final ViewHolder holder =null;
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        }
        else
        {
            for (Other wp : arraylist)
            {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}

