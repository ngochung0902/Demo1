package com.company.qts.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.qts.object.Story1;

/**
 * Created by MyPC on 06/09/2017.
 */
public class AdapterVPGRelative extends PagerAdapter {
    private Context mContext;

    public AdapterVPGRelative(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        Story1 story1 = Story1.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(story1.getmLayout(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return Story1.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Story1 customPagerEnum = Story1.values()[position];
        return mContext.getString(customPagerEnum.getmTitle());
    }
}
