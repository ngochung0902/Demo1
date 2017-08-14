package com.company.qts.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.demo1.ActShowFrm;
import com.company.qts.demo1.R;

/**
 * Created by MyPC on 14/08/2017.
 */
public class FrmTop extends Fragment {
    private Button bt_apply;
    private EditText edt_name,edt_year;
    private ImageView img_arrow;
    private ActShowFrm mainactivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_top, container, false);
        bt_apply = (Button) view.findViewById(R.id.bt_apply);
        edt_name = (EditText) view.findViewById(R.id.edt_name);
        edt_year = (EditText) view.findViewById(R.id.edt_year);
        img_arrow = (ImageView) view.findViewById(R.id.img_arrow);

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        bt_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyText();
            }
        });
        edt_year.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = true;
                if (actionId== EditorInfo.IME_ACTION_DONE){
                    applyText();
                }
                return handled;
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ActShowFrm){
            this.mainactivity = (ActShowFrm) context;
        }
    }

    private void applyText() {
        String toptext = this.edt_name.getText().toString();
        String bottomtext = this.edt_year.getText().toString();

        this.mainactivity.showText(toptext,bottomtext);
    }
}
