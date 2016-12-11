package com.example.abhishek.corporatesocialresponsibility;

import android.webkit.WebView;

/**
 * Created by Abhishek on 11-12-2016.
 */
public class WebViewClient extends android.webkit.WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url)
    {
        v.loadUrl(url);
        return true;
    }
}
