package com.company.qts.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.qts.Object.Story;

/**
 * Created by MyPC on 01/08/2017.
 */
public class AdapterViewpager extends PagerAdapter {

    private Context mContext;

    public AdapterViewpager(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        Story story = Story.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(story.getmLayout(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return Story.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Story customPagerEnum = Story.values()[position];
        return mContext.getString(customPagerEnum.getmTitle());
    }
}
