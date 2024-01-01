package com.example.lprincesssbloglimengjueroe21005;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mNameLimengjue,mpwdLimengjue;
    Button mbtnloginLimengjue,mbtnregLimengjue;
    MysqlROE21005 mmysqlLimengjue;
    SQLiteDatabase mdbLimengjue;
    SharedPreferences msp1Limengjue,msp2Limengjue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameLimengjue = this.findViewById(R.id.name); //username
        mpwdLimengjue = this.findViewById(R.id.pwd); //password
        mbtnregLimengjue = this.findViewById(R.id.reg);
        mbtnloginLimengjue = this.findViewById(R.id.login);

        msp1Limengjue = this.getSharedPreferences("userinfo", MODE_PRIVATE);
        msp2Limengjue = this.getSharedPreferences("username", MODE_PRIVATE);
        mNameLimengjue.setText(msp1Limengjue.getString("username",null));
        mpwdLimengjue.setText(msp1Limengjue.getString("userpwd",null));
        mmysqlLimengjue = new MysqlROE21005(this,"Userinfo",null,1); //建数据库或取数据库
        mdbLimengjue = mmysqlLimengjue.getReadableDatabase();


        mbtnloginLimengjue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String musernameLimengjue = mNameLimengjue.getText().toString();
                String mpasswordLimengjue = mpwdLimengjue.getText().toString();
                //查询
                @SuppressLint("Recycle") Cursor cursorlimengjue = mdbLimengjue.query("logins",new String[]{"username","userpwd"},"username=? and userpwd=?",new String[]{musernameLimengjue,mpasswordLimengjue},null,null,null);
                // 查询记录项数，如果=0那就是没有该用户

                int mflagLimengjue = cursorlimengjue.getCount();

                if(mflagLimengjue!=0){
                    SharedPreferences.Editor meditorLimengjue = msp2Limengjue.edit();
                    //把光标移动到position为0的位置，默认为-1
                    cursorlimengjue.moveToFirst();
                    String mloginnameLimengjue = cursorlimengjue.getString(0);
                    // 更改数据
                    meditorLimengjue.putString("Loginname",mloginnameLimengjue);
                    meditorLimengjue.apply();
                    // Toast.makeText(MainActivity.this,"apply",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,WelcomeROE21005.class));
                }
                else{
                    Toast.makeText(MainActivity.this,"Whoops!用户名或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });



        mbtnregLimengjue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vlimengjue) {
                setContentView(R.layout.activity_register_roe21005);
                Log.d("MainActivity","onClick:previous");
                startActivity(new Intent(MainActivity.this,RegisterROE21005.class));
                Toast.makeText(MainActivity.this,"前往注册~~~~~",Toast.LENGTH_LONG).show();
            }
        });

    }

}