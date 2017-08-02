package com.company.qts.demo1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActQuangNam extends AppCompatActivity {
    private TextView tv_quangnam,tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_quang_nam);
        initUI();
        quangnam();
        text();
    }

    private void text() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/ProximaNovaRegItalic.otf");
        tv_text.setTypeface(typeface);
    }

    private void quangnam() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/ProximaNovaBold.otf");
        tv_quangnam.setTypeface(typeface);
    }

    private void initUI() {
        tv_quangnam = (TextView) findViewById(R.id.tv_quangnam);
        tv_text = (TextView) findViewById(R.id.tv_text);
    }
}
