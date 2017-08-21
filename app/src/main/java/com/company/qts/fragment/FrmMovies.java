package com.company.qts.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.company.qts.demo1.ActShowMovies;
import com.company.qts.demo1.ActShowMovies1;
import com.company.qts.demo1.R;
import com.company.qts.object.MoviesFrm;

import java.util.ArrayList;

/**
 * Created by MyPC on 17/08/2017.
 */
public class FrmMovies extends Fragment {

    private ArrayList<MoviesFrm> arr = new ArrayList<>();
    private ListView lv_movies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_movies, container, false);
        lv_movies = (ListView) view.findViewById(R.id.lv_movies);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (arr.size()<1){
            dataarr();
        }else {

        }
        AdapterLVMovies adapter = new AdapterLVMovies(getActivity(),arr);
        lv_movies.setAdapter(adapter);
        lv_movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    Intent i = new Intent(getActivity(), ActShowMovies.class);
                    startActivity(i);
                }
                if (position==1){
                    Intent i = new Intent(getActivity(), ActShowMovies1.class);
                    startActivity(i);
                }
            }
        });
    }

    private void dataarr() {
        arr.add((new MoviesFrm(R.drawable.game1,"Pokemon1","Monday","2012")));
        arr.add((new MoviesFrm(R.drawable.game2,"Pokemon2","Tuesday","2013")));
        arr.add((new MoviesFrm(R.drawable.game3,"Pokemon3","Wednesday","2014")));
        arr.add((new MoviesFrm(R.drawable.game4,"Pokemon4","Thursday","2015")));
        arr.add((new MoviesFrm(R.drawable.game5,"Pokemon5","Friday","2016")));
        arr.add((new MoviesFrm(R.drawable.game6,"Pokemon6","Saturday","2017")));
    }

    //----------------------------------------------------------------------------------------------------------------------
    public class AdapterLVMovies extends BaseAdapter {

        Context context;
        ArrayList<MoviesFrm> arrayList;

        public AdapterLVMovies(Context context, ArrayList<MoviesFrm> arrayList) {
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
            convertView = inflater.inflate(R.layout.item_lv_movies,null);

            MoviesFrm frmMovies = arrayList.get(position);

            TextView tv_namemovie = (TextView) convertView.findViewById(R.id.tv_namemovie);
            TextView tv_day = (TextView) convertView.findViewById(R.id.tv_day);
            TextView tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            ImageView img_movies = (ImageView) convertView.findViewById(R.id.img_movies);

            tv_namemovie.setText(frmMovies.getTv_namemovies());
            tv_day.setText(frmMovies.getTv_day());
            tv_year.setText(frmMovies.getTv_year());
            img_movies.setImageResource(frmMovies.getImg_movies());
            return convertView;
        }
    }
}

