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
        // Listen for ListView Item Click
//        view.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // Send single item click data to SingleItemView Class
//                Intent intent = new Intent(mContext, SingleItemView.class);
//                // Pass all data rank
//                intent.putExtra("rank",(worldpopulationlist.get(position).getName()));
//                // Pass all data flag
//                // Start SingleItemView Class
//                mContext.startActivity(intent);
//            }
//        });
//
        return view;
    }
    // Filter Class
    public void filter(String charText) {
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

