package com.buti.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
    }

    @Override
    public void onBackPressed() {
        webView.evaluateJavascript(
            "typeof showTab==='function' ? (showTab('home'),'home') : 'exit'",
            result -> {
                if ("\"exit\"".equals(result)) {
                    super.onBackPressed();
                }
            }
        );
    }
}
