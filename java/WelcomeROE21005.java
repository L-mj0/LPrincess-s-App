package com.example.lprincesssbloglimengjueroe21005;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeROE21005 extends AppCompatActivity {
    SharedPreferences splimengjue;
    TextView showhellolimengjue;
    Button btnlimengjue;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        // Toast.makeText(WelcomeROE21005.this,"Welcome~",Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome_roe21005);
        btnlimengjue=this.findViewById(R.id.welcome);
        splimengjue = this.getSharedPreferences("username",this.MODE_PRIVATE);
        showhellolimengjue = this.findViewById(R.id.mainword);
        // Toast.makeText(WelcomeROE21005.this,"build success~",Toast.LENGTH_LONG).show();

        if(showhellolimengjue != null){
            showhellolimengjue.setText("Welcome! "+splimengjue.getString("Loginname",""));
        }
        else{
            Log.e("WelcomeROE21005","TestView is null");
        }

        btnlimengjue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_initpage_roe21005);
                // Toast.makeText(WelcomeROE21005.this,"activity success~",Toast.LENGTH_LONG).show();
                Log.d("Welcome","onClick:previous");
                startActivity(new Intent(WelcomeROE21005.this,InitpageROE21005.class));
                // Toast.makeText(WelcomeROE21005.this,"前往主页~~~~~",Toast.LENGTH_LONG).show();
            }
        });

    }
}
