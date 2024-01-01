package com.example.lprincesssbloglimengjueroe21005;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class IntroductionROE21005 extends AppCompatActivity {
    ImageView indexlimengjue,guitarlimengjue,musiclimengjue;
    TextView guitartextlimengjue,tvlikeslimengjue1,tvlikeslimengjue2,pianotextlimengjue,dancetextlimengjue,tvlikeslimengjue3;
    Button btnlikelimengjue1,btncommentlimengjue1,btnlikelimengjue2,btncommentlimengjue2,btnlikelimengjue3,btncommentlimengjue3;
    EditText etCommentlimengjue1,etCommentlimengjue2,etCommentlimengjue3;
    MysqlROE21005 mysqllimengjue;
    SQLiteDatabase dblimengjue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_roe21005);
        // Toast.makeText(IntroductionROE21005.this,"进入介绍界面啦",Toast.LENGTH_LONG).show();

        mysqllimengjue = new MysqlROE21005(this,"db_user",null,1);
        dblimengjue = mysqllimengjue.getReadableDatabase();

        indexlimengjue = this.findViewById(R.id.index);
        guitarlimengjue = this.findViewById(R.id.guitar);
        guitartextlimengjue = this.findViewById(R.id.guitar_text);
        musiclimengjue = this.findViewById(R.id.music_title);
        pianotextlimengjue = this.findViewById(R.id.piano_text);
        dancetextlimengjue = this.findViewById(R.id.dance_text);

        Typeface typefacelimengjue = Typeface.createFromAsset(getAssets(),"fonts/comic_sans_ms.ttf");
        guitartextlimengjue.setTypeface(typefacelimengjue);
        pianotextlimengjue.setTypeface(typefacelimengjue);
        dancetextlimengjue.setTypeface(typefacelimengjue);
        // Toast.makeText(IntroductionROE21005.this,"字体设置成功",Toast.LENGTH_LONG).show();

        // 点赞和评论
        btnlikelimengjue1 = findViewById(R.id.btn_like1);
        btnlikelimengjue2 = findViewById(R.id.btn_like2);
        btnlikelimengjue3 = findViewById(R.id.btn_like3);
        tvlikeslimengjue1 = findViewById(R.id.tv_likes1);
        tvlikeslimengjue2 = findViewById(R.id.tv_likes2);
        tvlikeslimengjue3 = findViewById(R.id.tv_likes3);
        etCommentlimengjue1 = findViewById(R.id.ed_comment1);
        etCommentlimengjue2 = findViewById(R.id.ed_comment2);
        etCommentlimengjue3 = findViewById(R.id.ed_comment3);
        btncommentlimengjue1 = findViewById(R.id.btn_comment1);
        btncommentlimengjue2 = findViewById(R.id.btn_comment2);
        btncommentlimengjue3 = findViewById(R.id.btn_comment3);

        updateCommentsDisplay(0);
        updateCommentsDisplay2(0);
        updateCommentsDisplay3(0);

        for(int i=1;i<=3;i++){
            updateLikesDisplay(i);
        }

        btnlikelimengjue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysqllimengjue.addLike(1);
                updateLikesDisplay(1);
            }
        });

        btnlikelimengjue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mysqllimengjue.addLike(2);
                updateLikesDisplay(2);
            }
        });

        btnlikelimengjue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewlimengjue) {
                mysqllimengjue.addLike(3);
                updateLikesDisplay(3);
            }
        });


        btncommentlimengjue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewlimengjue) {
                String commentlimengjue = etCommentlimengjue1.getText().toString();
                // 处理提交评论逻辑
                // Toast.makeText(IntroductionROE21005.this,"成功评论："+comment,Toast.LENGTH_LONG).show();
                if(!commentlimengjue.isEmpty()){
                    int itemIdlimengjue=1;
                    mysqllimengjue.addComment(itemIdlimengjue,commentlimengjue);
                    Toast.makeText(IntroductionROE21005.this,"成功评论："+commentlimengjue,Toast.LENGTH_LONG).show();
                    // 清除输入框
                    etCommentlimengjue1.setText("");
                    //更新界面上的评论列表
                    updateCommentsDisplay(1);
                }else{
                    Toast.makeText(IntroductionROE21005.this,"评论不能为空！", Toast.LENGTH_LONG).show();
                }

            }
        });

        btncommentlimengjue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewlimengjue) {
                String commentlimengjue = etCommentlimengjue2.getText().toString();
                // 处理提交评论逻辑
                // Toast.makeText(IntroductionROE21005.this,"成功评论："+comment,Toast.LENGTH_LONG).show();
                if(!commentlimengjue.isEmpty()){
                    int itemIdlimengjue=2;
                    mysqllimengjue.addComment(itemIdlimengjue,commentlimengjue);
                    Toast.makeText(IntroductionROE21005.this,"成功评论："+commentlimengjue,Toast.LENGTH_LONG).show();
                    // 清除输入框
                    etCommentlimengjue2.setText("");
                    //更新界面上的评论列表
                    updateCommentsDisplay2(1);
                }else{
                    Toast.makeText(IntroductionROE21005.this,"评论不能为空！", Toast.LENGTH_LONG).show();
                }
            }
        });

        btncommentlimengjue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewlimengjue) {
                String commentlimengjue = etCommentlimengjue3.getText().toString();
                // 处理提交评论逻辑
                // Toast.makeText(IntroductionROE21005.this,"成功评论："+comment,Toast.LENGTH_LONG).show();
                if(!commentlimengjue.isEmpty()){
                    int itemId=3;
                    mysqllimengjue.addComment(itemId,commentlimengjue);
                    Toast.makeText(IntroductionROE21005.this,"成功评论："+commentlimengjue,Toast.LENGTH_LONG).show();
                    // 清除输入框
                    etCommentlimengjue3.setText("");
                    //更新界面上的评论列表
                    updateCommentsDisplay3(1);
                }else{
                    Toast.makeText(IntroductionROE21005.this,"评论不能为空！", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    private void updateCommentsDisplay(int modellimengjue) {
        // Toast.makeText(IntroductionROE21005.this, "count：" + count, Toast.LENGTH_LONG).show();
        Cursor cursorlimengjue = mysqllimengjue.getComments(1);
        List<String> comments1limengjue = new ArrayList<>();

        if(cursorlimengjue != null && cursorlimengjue.moveToFirst()){
            do{
                int idlimengjue = cursorlimengjue.getInt(1);
                String commentlimengjue= cursorlimengjue.getString(2);
                String formattedComment = idlimengjue + " : " + commentlimengjue;
                comments1limengjue.add(formattedComment);
            }while(cursorlimengjue.moveToNext());
        }
        if(cursorlimengjue!=null){
            cursorlimengjue.close();
        }
        if(modellimengjue == 0){
            LinearLayout commentsLayoutlimengjue = findViewById(R.id.ViewComments1);

            for(String formattedCommentlimengjue : comments1limengjue){
                TextView textViewlimengjue = new TextView(this);
                textViewlimengjue.setText(formattedCommentlimengjue);
                textViewlimengjue.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                textViewlimengjue.setPadding(10,10,10,10);
                textViewlimengjue.setTextSize(16);
                commentsLayoutlimengjue.addView(textViewlimengjue);
            }
        }
        else if(modellimengjue == 1){
            SQLiteDatabase dblimengjue = mysqllimengjue.getReadableDatabase();
            Cursor cursor_cnlimengjue = dblimengjue.rawQuery("SELECT COUNT(*) FROM comments1", null);
            // 遍历Cursor，将评论数据添加到界面上
            int countlimengjue = 0; // 初始化 count
            if (cursor_cnlimengjue.moveToFirst()) {
                countlimengjue = cursor_cnlimengjue.getInt(0);
            }
            cursor_cnlimengjue.close(); // 关闭 cursor
            LinearLayout commentsLayoutlimengjue = findViewById(R.id.ViewComments1);
            int ilimengjue=1;
            for(String formattedCommentlimengjue : comments1limengjue){
                if(ilimengjue==countlimengjue){
                    TextView textViewlimengjue = new TextView(this);
                    textViewlimengjue.setText(formattedCommentlimengjue);
                    textViewlimengjue.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    textViewlimengjue.setPadding(10,10,10,10);
                    textViewlimengjue.setTextSize(16);
                    commentsLayoutlimengjue.addView(textViewlimengjue);
                }
                ilimengjue++;
            }
        }
    }

    private void updateCommentsDisplay2(int modellimengjue) {
        SQLiteDatabase dblimengjue = mysqllimengjue.getReadableDatabase();
        Cursor cursor_cnlimengjue = dblimengjue.rawQuery("SELECT COUNT(*) FROM comments2", null);
        // 遍历Cursor，将评论数据添加到界面上
        int countlimengjue = 0;
        if (cursor_cnlimengjue.moveToFirst()) {
            countlimengjue = cursor_cnlimengjue.getInt(0);
        }
        cursor_cnlimengjue.close();
        // Toast.makeText(IntroductionROE21005.this, "count：" + count, Toast.LENGTH_LONG).show();
        Cursor cursorlimengjue = mysqllimengjue.getComments(2);
        List<String> comments2limengjue = new ArrayList<>();

        if(cursorlimengjue != null && cursorlimengjue.moveToFirst()){
            do{
                int idlimengjue = cursorlimengjue.getInt(1);
                String commentlimengjue = cursorlimengjue.getString(2);
                String formattedCommentlimengjue = idlimengjue + " : " + commentlimengjue;
                comments2limengjue.add(formattedCommentlimengjue);
            }while(cursorlimengjue.moveToNext());
        }
        if(cursorlimengjue!=null){
            cursorlimengjue.close();
        }
        if(modellimengjue == 0){

            LinearLayout commentsLayoutlimengjue = findViewById(R.id.ViewComments2);

            for(String formattedCommentlimengjue : comments2limengjue){
                TextView textViewlimengjue = new TextView(this);
                textViewlimengjue.setText(formattedCommentlimengjue);
                textViewlimengjue.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                textViewlimengjue.setPadding(10,10,10,10);
                textViewlimengjue.setTextSize(16);
                commentsLayoutlimengjue.addView(textViewlimengjue);
            }
        }
        else if(modellimengjue == 1){
            LinearLayout commentsLayoutlimengjue = findViewById(R.id.ViewComments2);
            int ilimengjue=1;
            for(String formattedCommentlimengjue : comments2limengjue){
                if(ilimengjue==countlimengjue){
                    TextView textViewlimengjue = new TextView(this);
                    textViewlimengjue.setText(formattedCommentlimengjue);
                    textViewlimengjue.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    textViewlimengjue.setPadding(10,10,10,10);
                    textViewlimengjue.setTextSize(16);
                    commentsLayoutlimengjue.addView(textViewlimengjue);
                }
                ilimengjue++;
            }
        }
    }

    private void updateCommentsDisplay3(int modellimengjue) {
        // Toast.makeText(IntroductionROE21005.this, "count：" + count, Toast.LENGTH_LONG).show();
        Cursor cursorlimengjue = mysqllimengjue.getComments(3);
        List<String> comments3limengjue = new ArrayList<>();

        if(cursorlimengjue != null && cursorlimengjue.moveToFirst()){
            do{
                int id = cursorlimengjue.getInt(1);
                String comment = cursorlimengjue.getString(2);
                String formattedComment = id + " : " + comment;
                comments3limengjue.add(formattedComment);
            }while(cursorlimengjue.moveToNext());
        }
        if(cursorlimengjue!=null){
            cursorlimengjue.close();
        }
        if(modellimengjue == 0){
            LinearLayout commentsLayoutlimengjue = findViewById(R.id.ViewComments3);

            for(String formattedCommentlimengjue : comments3limengjue){
                TextView textViewlimengjue = new TextView(this);
                textViewlimengjue.setText(formattedCommentlimengjue);
                textViewlimengjue.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                textViewlimengjue.setPadding(10,10,10,10);
                textViewlimengjue.setTextSize(16);
                commentsLayoutlimengjue.addView(textViewlimengjue);
            }
        }
        else if(modellimengjue == 1){
            SQLiteDatabase dblimengjue = mysqllimengjue.getReadableDatabase();
            Cursor cursor_cnlimengjue = dblimengjue.rawQuery("SELECT COUNT(*) FROM comments3", null);
            // 遍历Cursor，将评论数据添加到界面上
            int countlimengjue = 0;
            if (cursor_cnlimengjue.moveToFirst()) {
                countlimengjue = cursor_cnlimengjue.getInt(0);
            }
            cursor_cnlimengjue.close();
            LinearLayout commentsLayoutlimengjue = findViewById(R.id.ViewComments3);
            int ilimengjue=1;
            for(String formattedCommentlimengjue : comments3limengjue){
                if(ilimengjue==countlimengjue){
                    TextView textViewlimengjue = new TextView(this);
                    textViewlimengjue.setText(formattedCommentlimengjue);
                    textViewlimengjue.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    textViewlimengjue.setPadding(10,10,10,10);
                    textViewlimengjue.setTextSize(16);
                    commentsLayoutlimengjue.addView(textViewlimengjue);
                }
                ilimengjue++;
            }
        }
    }

    private void updateLikesDisplay(int itemIdlimengjue){
        SQLiteDatabase dblimengjue = mysqllimengjue.getReadableDatabase();
        Cursor cursorlimengjue = dblimengjue.rawQuery("SELECT likes FROM likes Where item_id = ?",new String[]{String.valueOf(itemIdlimengjue)});

        if(cursorlimengjue.moveToFirst()){
            @SuppressLint("Range") int likeslimengjue = cursorlimengjue.getInt(cursorlimengjue.getColumnIndex("likes"));
            if(itemIdlimengjue == 1){
                TextView tvLikes1limengjue = findViewById(R.id.tv_likes1);
                tvLikes1limengjue.setText(String.valueOf(likeslimengjue));
            }
            else if(itemIdlimengjue == 2){
                TextView tvLikes2limengjue = findViewById(R.id.tv_likes2);
                tvLikes2limengjue.setText(String.valueOf(likeslimengjue));
            }
            else{
                TextView tvLikes2limengjue = findViewById(R.id.tv_likes3);
                tvLikes2limengjue.setText(String.valueOf(likeslimengjue));
            }
        }
        // cursor.close();
        // dblimengjue.close();
    }


}
