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
        "(function(){" +
        "var modal=document.querySelector('.modal.show, .modal.active, .modal[style*=\"display: block\"], .modal[style*=\"display:block\"]');" +
        "if(modal){" +
        "modal.style.display='none';" +
        "modal.classList.remove('show','active');" +
        "return 'closed';" +
        "}" +
        "var active=document.querySelector('section.active');" +
        "if(active && active.id!=='home'){" +
        "if(typeof showTab==='function'){showTab('home');}" +
        "return 'home';" +
        "}" +
        "return 'exit';" +
        "})()",
        result -> {
            if (result == null || "\"exit\"".equals(result)) {
                MainActivity.super.onBackPressed();
            }
        }
    )
}
}
