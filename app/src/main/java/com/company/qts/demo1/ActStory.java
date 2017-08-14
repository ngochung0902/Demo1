package com.company.qts.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.company.qts.adapter.AdapterViewpager;
import com.company.qts.hei.ActHEISplash;

public class ActStory extends AppCompatActivity {

    private ViewPager vpg_story;
    private ImageView img_arrow,ic_circleoff1,ic_circleoff2,ic_circleoff3,img_back,img_next;
    private Button bt_HEILogin;
    private LinearLayout ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_story);
        initUI();
        ln.setVisibility(View.GONE);
        bt_HEILogin.setVisibility(View.GONE);
        img_back.setVisibility(View.INVISIBLE);
        img_next.setVisibility(View.VISIBLE);
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpg_story.setCurrentItem(1);
            }
        });
        vpg_story.setAdapter(new AdapterViewpager(this));
        vpg_story.setCurrentItem(0);
        ic_circleoff1.setImageResource(R.drawable.ic_circleon);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ic_circleoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpg_story.setCurrentItem(0);
                ic_circleoff1.setImageResource(R.drawable.ic_circleon);
                ic_circleoff2.setImageResource(R.drawable.ic_circleoff);
                ic_circleoff3.setImageResource(R.drawable.ic_circleoff);

            }
        });

        ic_circleoff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpg_story.setCurrentItem(1);
                ic_circleoff1.setImageResource(R.drawable.ic_circleoff);
                ic_circleoff2.setImageResource(R.drawable.ic_circleon);
                ic_circleoff3.setImageResource(R.drawable.ic_circleoff);
            }
        });

        ic_circleoff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpg_story.setCurrentItem(2);
                ic_circleoff1.setImageResource(R.drawable.ic_circleoff);
                ic_circleoff2.setImageResource(R.drawable.ic_circleoff);
                ic_circleoff3.setImageResource(R.drawable.ic_circleon);
            }
        });

        vpg_story.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    img_back.setVisibility(View.INVISIBLE);
                    img_next.setVisibility(View.VISIBLE);
                    ic_circleoff1.setImageResource(R.drawable.ic_circleon);
                    ic_circleoff2.setImageResource(R.drawable.ic_circleoff);
                    ic_circleoff3.setImageResource(R.drawable.ic_circleoff);
                    img_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vpg_story.setCurrentItem(1);
                        }
                    });

                    ln.setVisibility(View.GONE);
                    bt_HEILogin.setVisibility(View.GONE);
                }
                if (position==1){
                    img_back.setVisibility(View.VISIBLE);
                    img_next.setVisibility(View.VISIBLE);
                    ic_circleoff1.setImageResource(R.drawable.ic_circleoff);
                    ic_circleoff2.setImageResource(R.drawable.ic_circleon);
                    ic_circleoff3.setImageResource(R.drawable.ic_circleoff);
                    img_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vpg_story.setCurrentItem(0);
                        }
                    });
                    img_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vpg_story.setCurrentItem(2);
                        }
                    });

                    ln.setVisibility(View.GONE);
                    bt_HEILogin.setVisibility(View.GONE);
                }
                if (position==2){
                    img_back.setVisibility(View.VISIBLE);
                    img_next.setVisibility(View.INVISIBLE);
                    ic_circleoff1.setImageResource(R.drawable.ic_circleoff);
                    ic_circleoff2.setImageResource(R.drawable.ic_circleoff);
                    ic_circleoff3.setImageResource(R.drawable.ic_circleon);
                    img_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vpg_story.setCurrentItem(1);
                        }
                    });

                    ln.setVisibility(View.VISIBLE);
                    bt_HEILogin.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bt_HEILogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActStory.this,ActHEISplash.class);
                startActivity(intent);
            }
        });
    }

    private void initUI() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_next = (ImageView) findViewById(R.id.img_next);
        vpg_story = (ViewPager) findViewById(R.id.vpg_story);
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        ic_circleoff1 = (ImageView) findViewById(R.id.ic_circleoff1);
        ic_circleoff2 = (ImageView) findViewById(R.id.ic_circleoff2);
        ic_circleoff3 = (ImageView) findViewById(R.id.ic_circleoff3);
        bt_HEILogin = (Button) findViewById(R.id.bt_loginHEI);
        ln = (LinearLayout) findViewById(R.id.ln);
    }
}
