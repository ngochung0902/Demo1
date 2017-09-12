package com.company.qts.englishgrammar.activity;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.company.qts.demo1.R;

import java.util.ArrayList;

/**
 * Created by tuanlq on 7/26/2016.
 */
public class DetailLessionAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<LessionModel> arr;

    public DetailLessionAdapter(Context context, ArrayList<LessionModel> arr)
    {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.lession_dettail_item, container, false);
        // find view
        WebView webView = (WebView) view.findViewById(R.id.web_view);
        String url = "file:///android_asset/" + arr.get(position).lessionName + ".htm";
        url = url.replace(" ", "%20");

        webView.loadUrl(url);
        // show zoom control
        webView.getSettings().setBuiltInZoomControls(true);

        container.addView(view);

        return view;
    }
}
