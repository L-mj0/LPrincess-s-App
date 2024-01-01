package com.example.lprincesssbloglimengjueroe21005;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MinesweeperROE21005 extends Activity {
    WebView weblimengjue;

    @SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceStatelimengjue) {
        super.onCreate(savedInstanceStatelimengjue);
        setContentView(R.layout.activity_github_roe21005);

        weblimengjue = findViewById(R.id.web_view);

        String urllimengjue ="https://www.minesweeper.cn/";
        weblimengjue.loadUrl(urllimengjue);
        weblimengjue.getSettings().setJavaScriptEnabled(true);
        weblimengjue.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed(){
        if((weblimengjue!=null)&&(weblimengjue.canGoBack())){
            weblimengjue.goBackOrForward(-1);
        }
        else{
            super.onBackPressed();
        }

    }

}
