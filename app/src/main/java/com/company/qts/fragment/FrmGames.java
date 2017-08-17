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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.demo1.ActShowGVGame;
import com.company.qts.demo1.R;
import com.company.qts.object.GameFrm;

import java.util.ArrayList;

/**
 * Created by MyPC on 17/08/2017.
 */
public class FrmGames extends Fragment {
    private GridView gv_frmgame;
    private ArrayList<GameFrm> arr = new ArrayList<>();
    private AdapterGameFrm mAdapter;
    Integer[]mThumbIds;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_games, container, false);
        gv_frmgame = (GridView) view.findViewById(R.id.gv_frmgame);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (arr.size()<=1){
            dataarr();
        }else {
        }
        mThumbIds=new Integer[]{R.drawable.game1,R.drawable.game2,
                R.drawable.game3,R.drawable.game4,
                R.drawable.game5,R.drawable.game6,};
        mAdapter = new AdapterGameFrm(getActivity(), arr);
        gv_frmgame.setAdapter(mAdapter);
        gv_frmgame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), ActShowGVGame.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }

    public void dataarr() {
        arr.add((new GameFrm(R.drawable.game1,"Pokemon1")));
        arr.add((new GameFrm(R.drawable.game2,"Pokemon2")));
        arr.add((new GameFrm(R.drawable.game3,"Pokemon3")));
        arr.add((new GameFrm(R.drawable.game4,"Pokemon4")));
        arr.add((new GameFrm(R.drawable.game5,"Pokemon5")));
        arr.add((new GameFrm(R.drawable.game6,"Pokemon6")));
    }

    //-------------------------------------------------------------------------------------------------------------------------------------
    public class AdapterGameFrm extends BaseAdapter {

        Context context;
        ArrayList<GameFrm> arrayList;

        public AdapterGameFrm(Context context, ArrayList<GameFrm> arrayList) {
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
            convertView = inflater.inflate(R.layout.line_gvgame, null);

            GameFrm lineGv = arrayList.get(position);

            ImageView img_game = (ImageView) convertView.findViewById(R.id.img_game);
            TextView tv_namegame = (TextView) convertView.findViewById(R.id.tv_namegame);

            tv_namegame.setText(lineGv.getNamegame());
            img_game.setImageResource(lineGv.getImg_game());
            return convertView;
        }
    }
}