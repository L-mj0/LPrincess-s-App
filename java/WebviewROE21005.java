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
import android.widget.TextView;
import android.widget.Toast;

public class WebviewROE21005  extends Activity{
    WebView weblimengjue;
    Button btliemngjue;
    TextView edlimengjue;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wwlj_roe21005);

        btliemngjue = findViewById(R.id.web_btn);
        edlimengjue = findViewById(R.id.web_text);
        weblimengjue = findViewById(R.id.web_view);

        btliemngjue.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               String urllimengjue = "https://"+edlimengjue.getText().toString();
               weblimengjue.loadUrl(urllimengjue);
               weblimengjue.getSettings().setJavaScriptEnabled(true);
               weblimengjue.setWebViewClient(new WebViewClient());
           }
        });

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
