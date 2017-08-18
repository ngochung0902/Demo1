package com.company.qts.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by MyPC on 18/08/2017.
 */
public class VideoView extends android.widget.VideoView {
    private int mForceHeight = 0;
    private int mForceWidth = 0;
    public VideoView(Context context) {
        super(context);
    }

    public VideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setDimensions(int w, int h) {
        this.mForceHeight = h;
        this.mForceWidth = w;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("@@@@", "onMeasure");

        setMeasuredDimension(mForceWidth, mForceHeight);
    }
}
