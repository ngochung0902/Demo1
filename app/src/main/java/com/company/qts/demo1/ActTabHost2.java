package com.company.qts.demo1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.company.qts.fragment.FrmBlue;
import com.company.qts.fragment.FrmGreen;
import com.company.qts.fragment.FrmRed;

public class ActTabHost2 extends AppCompatActivity implements FrmBlue.position {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        mViewPager.clearAnimation();
        mViewPager.clearFocus();

    }

    @Override
    public void p(int a) {
        mViewPager.setCurrentItem(1);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
                switch (position)
                {
                    case 0:
                        FrmBlue tab1 = new FrmBlue();
                        return tab1;
                    case 1:
                        FrmRed tab2 = new FrmRed();
                        return tab2;
                    case 2:
                        FrmGreen tab3 = new FrmGreen();
                        return tab3;
                    case 3:
                        FrmRed tab4 = new FrmRed();
                        return tab4;
                    case 4:
                        FrmGreen tab5 = new FrmGreen();
                        return tab5;
                    default:return null;
                }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "BLUE";
                case 1:
                    return "RED";
                case 2:
                    return "GREEN";
                case 3:
                    return "RED";
                case 4:
                    return "GREEN";
            }
            return null;
        }
    }
}
