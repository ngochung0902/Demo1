package com.company.qts.apiget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.company.qts.demo1.R;

public class PostDetailActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        initView();
    }
    private void initView() {
        webView = (WebView) findViewById(R.id.webView);

        showDetailPost(getIntent().getStringExtra("title"),
                getIntent().getStringExtra("content"),
                getIntent().getStringExtra("nameCa"),
                getIntent().getStringExtra("des"));
        Log.d("abc",getIntent().getStringExtra("title"));
        Log.d("abc",getIntent().getStringExtra("nameCa"));
        Log.d("abc",getIntent().getStringExtra("des"));
    }

    private void showDetailPost(String title, String content, String nameCa, String des) {
        webView.setBackgroundColor(Color.WHITE);
        webView.setFocusableInTouchMode(false);
        webView.setFocusable(false);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        String mimeType = "text/html; charset=UTF-8";
        String encoding = "utf-8";
        String htmlText = content;

        String text = "<html><head>"
                + "<meta name=\"viewport\" content=\"width=device-width, Result-scalable=no\" />"
                + "<style type=\"text/css\">img {margin: 0.5% 0px !important;border: 0;font-size: 0;line-height: 0;max-width: 100%;}</style></head>"
                + "<body><h2>" + title + "</h2></br>" +
                "<span style=\"color:#0aa485;\">" + nameCa + "</span> </br> " +
                "<p><h3>" + des + "</h3></p>"
                + htmlText + "</body></html>";

        webView.loadDataWithBaseURL(null,text, mimeType, encoding, null);
    }
}
