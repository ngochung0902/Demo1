package com.company.qts.demo1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.company.qts.adapter.AdapterVPGRelative;
import com.company.qts.helper.QTSHelp;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

public class ActRelative extends AppCompatActivity {
    RelativeLayout relativelayout3,relativelayout4,relativelayout5;
    ImageView img_arrow,ic_circleoff1,ic_circleoff2;
    ViewPager vpg_relative;
    Timer timer;
    AdapterVPGRelative adapter;
    int page = 0;
    Button bt_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_relative);
        relativelayout3 = (RelativeLayout) findViewById(R.id.relativelayout3);
        relativelayout4 = (RelativeLayout) findViewById(R.id.relativelayout4);
        relativelayout5 = (RelativeLayout) findViewById(R.id.relativelayout5);
        ic_circleoff1 = (ImageView) findViewById(R.id.ic_circleoff1);
        ic_circleoff2 = (ImageView) findViewById(R.id.ic_circleoff2);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        vpg_relative = (ViewPager) findViewById(R.id.vpg_relative);
        bt_ok = (Button) findViewById(R.id.bt_ok);
        adapter = new AdapterVPGRelative(this);
        vpg_relative.setAdapter(adapter);
        vpg_relative.setCurrentItem(0);
        ic_circleoff1.setImageResource(R.drawable.ic_circleon);
        pageSwitcher(3);
        QTSHelp.setLayoutView(relativelayout3,QTSHelp.GetWidthDevice(this),QTSHelp.GetHeightDevice(this)/3);
        QTSHelp.setLayoutView(relativelayout4,QTSHelp.GetWidthDevice(this),QTSHelp.GetHeightDevice(this)/2);
        QTSHelp.setLayoutView(relativelayout5,QTSHelp.GetWidthDevice(this),QTSHelp.GetHeightDevice(this)/4);
        vpg_relative.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    ic_circleoff1.setImageResource(R.drawable.ic_circleon);
                    ic_circleoff2.setImageResource(R.drawable.ic_circleoff);
                }
                if (position==1){
                    ic_circleoff1.setImageResource(R.drawable.ic_circleoff);
                    ic_circleoff2.setImageResource(R.drawable.ic_circleon);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActRelative.this,ActProduct.class);
                startActivity(i);
            }
        });
        vpg_relative.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.5f);
                page.setScaleY(normalizedposition / 2 + 0.5f);
            }
        });
        try {
            Field mScroller;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            Interpolator sInterpolator = new AccelerateInterpolator();
            FixedSpeedScroller scroller = new FixedSpeedScroller(vpg_relative.getContext(), sInterpolator);
            mScroller.set(vpg_relative, scroller);
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }
    }

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                public void run() {

                    if (page >= 1) {
                        vpg_relative.setCurrentItem(page--);
                    } else {
                        vpg_relative.setCurrentItem(page++);
                    }
                }
            });
        }
    }

    public class FixedSpeedScroller extends Scroller {

        private int mDuration = 2000;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }


        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }
    }
}
