package com.company.qts.object;

import com.company.qts.demo1.R;

/**
 * Created by MyPC on 01/08/2017.
 */
public enum Story1 {
    STORY1(R.string.Story1, R.layout.story1,1),
    STORY2(R.string.Story2, R.layout.story2,2);

    private int mTitle;
    private int mLayout;
    private int mCircle;

    Story1(int mtitle, int mlayout, int mcircle) {
        mTitle = mtitle;
        mLayout = mlayout;
        mCircle = mcircle;
    }

    public int getmTitle() {
        return mTitle;
    }

    public int getmLayout() {
        return mLayout;
    }

    public int getmCircle() {
        return mCircle;
    }
}
//https://github.com/81813780/AVLoadingIndicatorView loanding