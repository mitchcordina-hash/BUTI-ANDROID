package com.buti.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity private WebView webView; {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
    }
@Override
public void onBackPressed() {
    WebView w = (WebView) ((android.view.ViewGroup)
            findViewById(android.R.id.content)).getChildAt(0);

    w.evaluateJavascript(
            "(function(){" +
            "var home=document.getElementById('home');" +
            "if(home && !home.classList.contains('active')){" +
            "showTab('home');" +
            "return 'home';" +
            "}" +
            "return 'exit';" +
            "})()",
            result -> {
                if (result != null && result.contains("exit")) {
                    MainActivity.super.onBackPressed();
                }
            }
    );
}}
