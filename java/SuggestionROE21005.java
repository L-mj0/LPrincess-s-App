package com.example.lprincesssbloglimengjueroe21005;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuggestionROE21005 extends AppCompatActivity {
    private EditText edsuggestiontestlimengjue,edcontactInfolimengjue;
    private Button btnSubmitlimengjue;
    private MysqlROE21005 dblimengjue;

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_suggestion_roe21005);

        dblimengjue = new MysqlROE21005(this,"db_user",null,2);

        edsuggestiontestlimengjue = findViewById(R.id.etSuggestion);
        edcontactInfolimengjue = findViewById(R.id.etContactInfo);
        btnSubmitlimengjue = findViewById(R.id.btnSubmit);

        btnSubmitlimengjue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveSuggestion();
            }
        });
    }

    public void saveSuggestion(){
        String suggestionlimengjue = edsuggestiontestlimengjue.getText().toString().trim();
        String contactInfolimengjue = edcontactInfolimengjue.getText().toString().trim();

        if(!suggestionlimengjue.isEmpty() && !contactInfolimengjue.isEmpty()){
            dblimengjue.addSuggestion(suggestionlimengjue, contactInfolimengjue);
            Toast.makeText(this, "提交成功~", Toast.LENGTH_SHORT).show();

            edsuggestiontestlimengjue.setText("");
            edcontactInfolimengjue.setText("");
        }else{
            Toast.makeText(this, "建议或者联系方式不能为空哦~", Toast.LENGTH_SHORT).show();
        }
    }

}
