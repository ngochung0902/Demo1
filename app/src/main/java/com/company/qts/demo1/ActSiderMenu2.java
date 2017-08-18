package com.company.qts.demo1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.company.qts.fragment.FrmGames;
import com.company.qts.fragment.FrmMovies;
import com.company.qts.helper.QTSHelp;

public class ActSiderMenu2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_siling_meu2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //--------------
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        LayoutInflater inflater = getLayoutInflater();
        View tab1 = inflater.inflate(R.layout.tabslidermenu1_indicator,null);
        View tab2 = inflater.inflate(R.layout.tabslidermenu2_indicator,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab1")
                        .setIndicator(tab1),
                FrmGames.class, null);

        mTabHost.addTab(mTabHost.newTabSpec("tab2")
                        .setIndicator(tab2),
                FrmMovies.class, null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            QTSHelp.showToast(ActSiderMenu2.this,"camera");
        } else if (id == R.id.nav_gallery) {
            QTSHelp.showToast(ActSiderMenu2.this,"gallery");
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            QTSHelp.showToast(ActSiderMenu2.this,"manage");
        } else if (id == R.id.nav_share) {
            QTSHelp.showToast(ActSiderMenu2.this,"share");
        } else if (id == R.id.nav_send) {
            QTSHelp.showToast(ActSiderMenu2.this,"send");
        }else if (id==R.id.ic_appgame){
            QTSHelp.showToast(ActSiderMenu2.this,"appgame");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
