package com.example.lprincesssbloglimengjueroe21005;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BlogLPrincessROE21005 extends Activity {
    WebView weblimengjue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_roe21005);

        weblimengjue = findViewById(R.id.web_view);

        String urllimengjue ="https://blog.lprincess.top";
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
