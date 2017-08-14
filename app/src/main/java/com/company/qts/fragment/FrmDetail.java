package com.company.qts.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.qts.demo1.R;

/**
 * Created by MyPC on 14/08/2017.
 */
public class FrmDetail extends Fragment {
    private static final String ARGUMENT_IMAGE_RES_ID = "imageResId";
    private static final String ARGUMENT_NAME = "name";
    private static final String ARGUMENT_DESCRIPTION = "description";
    private static final String ARGUMENT_URL = "url";

    private TextView tv_title,tv_sayright;
    private ImageView img_title;

    public static FrmDetail newInstance(int imageResId, String name, String description, String url){
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_IMAGE_RES_ID, imageResId);
        args.putString(ARGUMENT_NAME, name);
        args.putString(ARGUMENT_DESCRIPTION, description);
        args.putString(ARGUMENT_URL, url);
        final FrmDetail fragment = new FrmDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frm_detail, container, false);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_sayright = (TextView) view.findViewById(R.id.tv_sayright);
        img_title = (ImageView) view.findViewById(R.id.img_title);

        final Bundle args = getArguments();
        img_title.setImageResource(args.getInt(ARGUMENT_IMAGE_RES_ID));
        tv_title.setText(args.getString(ARGUMENT_NAME));
        final String text = String.format(getString(R.string.description_format), args.getString
                (ARGUMENT_DESCRIPTION), args.getString(ARGUMENT_URL));
        tv_sayright.setText(text);
        return view;
    }
}
