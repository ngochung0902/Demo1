package com.company.qts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.company.qts.object.Contacts;
import com.company.qts.demo1.R;

import java.util.ArrayList;

/**
 * Created by MyPC on 03/08/2017.
 */
public class AdapterContacts extends BaseAdapter {

    private Context context;
    private ArrayList<Contacts> arr;

    public AdapterContacts(Context context, ArrayList<Contacts> arr) {
        this.context = context;
        this.arr = arr;
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
        return (long)arr.get(position).Id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View rowView = (View)inflater.inflate(R.layout.line_contacts, parent, false);

        TextView tv_name = (TextView) rowView.findViewById(R.id.tv_name);
        TextView tv_phone = (TextView) rowView.findViewById(R.id.tv_phone);

        Contacts model = arr.get(position);
        tv_name.setText(model.getFistname()+" "+model.lastname);
        tv_phone.setText(model.getNumber());

        return rowView;
    }
}
