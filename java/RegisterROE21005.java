package com.example.lprincesssbloglimengjueroe21005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class RegisterROE21005 extends AppCompatActivity {

    EditText usernamelimengjue,userpwdlimengjue,userpwd2limengjue;
    Button sublimengjue;
    MysqlROE21005 mysqllimengjue;
    SQLiteDatabase dblimengjue;
    SharedPreferences splimengjue;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_roe21005);

        usernamelimengjue = this.findViewById(R.id.username);
        userpwdlimengjue = this.findViewById(R.id.userpwd);
        userpwd2limengjue = this.findViewById(R.id.userpwd2);
        sublimengjue = this.findViewById(R.id.sub);
        mysqllimengjue = new MysqlROE21005(this,"Userinfo",null,1);
        dblimengjue = mysqllimengjue.getReadableDatabase();
        splimengjue = this.getSharedPreferences("userinfo", MODE_PRIVATE);

        sublimengjue.setOnClickListener(new View.OnClickListener() {
            boolean flaglimengjue = true;
            @Override
            public void onClick(View view) {
                String namelimengjue = usernamelimengjue.getText().toString();
                String pwd01limengjue = userpwdlimengjue.getText().toString();
                String pwd02limengjue = userpwd2limengjue.getText().toString();
                if(namelimengjue.equals("")||pwd01limengjue.equals("")||pwd02limengjue.equals("")){
                    Toast.makeText(RegisterROE21005.this,"用户名或密码不能为空",Toast.LENGTH_LONG).show();
                }
                else{
                    Cursor cursorlimengjue = dblimengjue.query("logins",new String[]{"username"},null,null,null,null,null);

                    while(cursorlimengjue.moveToNext()){
                        if(cursorlimengjue.getString(0).equals(namelimengjue)){
                            flaglimengjue = false;
                            break;
                        }
                    }
                    if(flaglimengjue){   //判断用户是否存在
                        if(pwd01limengjue.equals(pwd02limengjue)){ //判断两次输入密码是否一致
                            ContentValues cvlimengjue = new ContentValues();
                            cvlimengjue.put("username",namelimengjue);
                            cvlimengjue.put("userpwd",pwd01limengjue);
                            dblimengjue.insert("logins",null,cvlimengjue);
                            SharedPreferences.Editor editorlimengjue = splimengjue.edit();
                            editorlimengjue.putString("username",namelimengjue);
                            editorlimengjue.putString("userpwd",pwd01limengjue);
                            editorlimengjue.apply();
                            //editorlimengjue.commit();
                            Intent intentlimengjue = new Intent();
                            // 跳转登录页面
                            intentlimengjue.setClass(RegisterROE21005.this,MainActivity.class);
                            startActivity(intentlimengjue);
                            Toast.makeText(RegisterROE21005.this,"Sucess!注册成功~",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(RegisterROE21005.this,"Whoops!密码不一致哦?",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterROE21005.this,"Whoops!用户已存在了，忘记啦？\n请重新尝试哦~",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

}
