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
        "var m=document.getElementById('expenseModal');" +
        "if(m && m.classList.contains('show')){" +
        "if(typeof closeExpense==='function') closeExpense();" +
        "return 'closed';" +
        "}" +
        "var a=document.querySelector('section.active');" +
        "if(a && a.id!=='home'){" +
        "if(typeof showTab==='function') showTab('home');" +
        "return 'home';" +
        "}" +
        "return 'exit';" +
        "})()",
        result -> {
            if ("\"exit\"".equals(result)) {
                MainActivity.super.onBackPressed();
            }
        }
    );
}
}
