package com.example.grade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText chineseET,englishET,mathET;
    Button submitb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chineseET=findViewById(R.id.editTextChinese);
        englishET=findViewById(R.id.editTextEnglish);
        mathET=findViewById(R.id.editTextMath);
        submitb=findViewById(R.id.buttonSubmit);
    }
    public boolean editcheck(EditText editext){
        int grade=Integer.parseInt(editext.getText().toString());
        if(grade<0||grade>100){
            editext.setError("0~100");
            return false;
        }
        else return true;
    }

    public void submitOnclick(View v){
        boolean editcheckboolean= editcheck(chineseET)&editcheck(englishET)&editcheck(mathET);
        if (!editcheckboolean){
            return;
        }
        int chinesegrade=Integer.parseInt(chineseET.getText().toString());
        int englishgrade=Integer.parseInt(englishET.getText().toString());
        int mathgrade=Integer.parseInt(mathET.getText().toString());
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,Submit.class);
        Bundle bundle=new Bundle();
        bundle.putInt("chinesegrade",chinesegrade);
        bundle.putInt("englishgrade",englishgrade);
        bundle.putInt("mathgrade",mathgrade);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
