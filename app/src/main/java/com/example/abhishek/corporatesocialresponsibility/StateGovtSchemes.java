package com.example.abhishek.corporatesocialresponsibility;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Abhishek on 11-12-2016.
 */
public class StateGovtSchemes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stategovtschemes);
        WebView browser = (WebView)findViewById(R.id.stategovtwebview);
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("http://www.ssa.uk.gov.in");
    }
}
