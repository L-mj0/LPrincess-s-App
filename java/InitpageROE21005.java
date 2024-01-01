package com.example.lprincesssbloglimengjueroe21005;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Objects;

public class InitpageROE21005 extends AppCompatActivity {
    private String[] channelDeclimengjue;
    private  int[] channelImglimengjue;
    private ArrayList<ChannelROE21005> channelListlimengjue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initpage_roe21005);
        Toast.makeText(InitpageROE21005.this,"激活成功，正在初始界面~",Toast.LENGTH_LONG).show();
        Toolbar toolbarlimengjue = findViewById(R.id.toolbar);
        setSupportActionBar(toolbarlimengjue);
        getSupportActionBar().setTitle("Welcome to LPrincess's App");
        initChannelView();
    }

    @SuppressLint("SetTextI18n")
    private void initChannelView() {
        GridView mGridViewlimengjue = findViewById(R.id.channel);

        channelImglimengjue = new int[]{
                R.id.grid_img1,
                R.id.grid_img2,
                R.id.grid_img3,
                R.id.grid_img4,
                R.id.grid_img5,
                R.id.grid_img6,
                R.id.grid_img7,
                R.id.grid_img8,
                R.id.grid_img9
        };

        channelDeclimengjue = new String[]{
                "Introduction",
                "Blog~",
                "Github~",
                "Minesweeper",
                "Reversi",
                "Overview",
                "外网链接",
                "bilibili",
                "给我建议~",
        };
        // Toast.makeText(InitpageROE21005.this,"初始化~",Toast.LENGTH_LONG).show();


        channelListlimengjue = new ArrayList<>();
        for(int i=0;i<channelDeclimengjue.length;i++){
            ChannelROE21005 channellimengjue = new ChannelROE21005();
            channellimengjue.setImgId(channelImglimengjue[i]);
            // Toast.makeText(InitpageROE21005.this,"setImgId-------",Toast.LENGTH_LONG).show();
            channellimengjue.setDec(channelDeclimengjue[i]);
            channelListlimengjue.add(channellimengjue);
        }
        // Toast.makeText(InitpageROE21005.this,"channelListlimengjue设置完成",Toast.LENGTH_LONG).show();

        mGridViewlimengjue.setAdapter(new ChannelAdapterROE21005(channelListlimengjue,this));

        // Toast.makeText(InitpageROE21005.this,"设置九宫格监听器~~~~~",Toast.LENGTH_LONG).show();
        // 九宫格设置监听器
        mGridViewlimengjue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentlimengjue, View viewlimengjue, int positionlimengjue, long idlimengjue) {
                switch (positionlimengjue){
                    case 0:
                        // Toast.makeText(InitpageROE21005.this,"准备前往介绍",Toast.LENGTH_LONG).show();
                        Intent intent1limengjue = new Intent(InitpageROE21005.this, IntroductionROE21005.class);
                        startActivity(intent1limengjue);
                        break;
                    case 1:
                        // Toast.makeText(InitpageROE21005.this,"TEST2",Toast.LENGTH_LONG).show();
                        Intent intent2limengjue = new Intent(InitpageROE21005.this, BlogLPrincessROE21005.class);
                        startActivity(intent2limengjue);
                        break;
                    case 2:
                        // Toast.makeText(InitpageROE21005.this,"TEST3",Toast.LENGTH_LONG).show();
                        // Toast.makeText(InitpageROE21005.this,"TEST2",Toast.LENGTH_LONG).show();
                        Intent intent3limengjue = new Intent(InitpageROE21005.this, GithubROE21005.class);
                        startActivity(intent3limengjue);
                        break;
                    case 3:
                        // Toast.makeText(InitpageROE21005.this,"TEST4",Toast.LENGTH_LONG).show();
                        Intent intent4limengjue = new Intent(InitpageROE21005.this, MinesweeperROE21005.class);
                        startActivity(intent4limengjue);
                        break;
                    case 4:
                        //Toast.makeText(InitpageROE21005.this,"TEST5",Toast.LENGTH_LONG).show();
                        Intent intent5limengjue = new Intent(InitpageROE21005.this, ReversiROE21005.class);
                        startActivity(intent5limengjue);
                        break;
                    case 5:
                        //Toast.makeText(InitpageROE21005.this,"TEST6",Toast.LENGTH_LONG).show();
                        Intent intent6limengjue = new Intent(InitpageROE21005.this, OverviewROE21005.class);
                        startActivity(intent6limengjue);
                        break;
                    case 6:
                        // Toast.makeText(InitpageROE21005.this,"TEST7",Toast.LENGTH_LONG).show();
                        Intent intent7limengjue = new Intent(InitpageROE21005.this, WebviewROE21005.class);
                        startActivity(intent7limengjue);
                        break;
                    case 7:
                        //Toast.makeText(InitpageROE21005.this,"TEST8",Toast.LENGTH_LONG).show();
                        Intent intent8limengjue = new Intent(InitpageROE21005.this, BilibiliROE21005.class);
                        startActivity(intent8limengjue);
                        break;
                    case 8:
                        //Toast.makeText(InitpageROE21005.this,"TEST9",Toast.LENGTH_LONG).show();
                        Intent intent9limengjue = new Intent(InitpageROE21005.this, SuggestionROE21005.class);
                        startActivity(intent9limengjue);
                        break;
                }
            }
        });
        // Toast.makeText(InitpageROE21005.this,"监听设置完成~",Toast.LENGTH_LONG).show();
    }
}
