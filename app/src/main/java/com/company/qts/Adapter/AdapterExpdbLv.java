package com.company.qts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.company.qts.demo1.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by MyPC on 31/07/2017.
 */
public class AdapterExpdbLv extends BaseExpandableListAdapter {

    Context context;
    List<String> listLevel;
    HashMap<String,List<String>> listClass;


    public AdapterExpdbLv(Context context, List<String> listLevel, HashMap<String, List<String>> listClass) {
        this.context = context;
        this.listLevel = listLevel;
        this.listClass = listClass;
    }

    @Override
    public int getGroupCount() {
        return listLevel.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listClass.get(listLevel.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listLevel.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listClass.get(listLevel.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String level = (String) getGroup(groupPosition);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.line_expblv_level,null);
        TextView tv_level = (TextView) convertView.findViewById(R.id.tv_level);
        tv_level.setText(level);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String Class = (String) getChild(groupPosition,childPosition);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.line_expblv_class,null);
        TextView tv_class = (TextView) convertView.findViewById(R.id.tv_class);
        tv_class.setText(Class);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
