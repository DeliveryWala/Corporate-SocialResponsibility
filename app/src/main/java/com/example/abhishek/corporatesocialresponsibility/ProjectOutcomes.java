package com.example.abhishek.corporatesocialresponsibility;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Abhishek on 11-12-2016.
 */
public class ProjectOutcomes extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_outcomes);
        WebView browser = (WebView)findViewById(R.id.projectwebView);
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://drive.google.com/open?id=0Bz7sz3HWyRonclFpcjd5MV9MTk0");
    }
}
