package com.example.grade;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Submit extends Activity {
    Button back;
    TextView printout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitlayout);
        back =findViewById(R.id.buttonBack);
        printout=findViewById(R.id.textViewPrintout);
        Printout();
    }

    public void Printout(){
        Bundle bundle = getIntent().getExtras();
        int chinesegrade = bundle.getInt("chinesegrade");
        int englishgrade = bundle.getInt("englishgrade");
        int mathgrade = bundle.getInt("mathgrade");
        int sum =chinesegrade+englishgrade+mathgrade;
        double averge = sum/3.0;
        printout.setText("Chinese: "+chinesegrade+"\nEnglish: "+englishgrade+"\nMath: "+mathgrade +"\nSum: "+sum);
        AvergeShow(averge);
    }
    public void AvergeShow(double averge){
        String messenge=new String();
        String title=new String();
        int pic=0;
        if (averge==100){
            messenge="Perfect";
            title="Pass";
            pic=R.drawable.pass;
        }
        else if(averge>=60){
            messenge="平均: "+String.valueOf(averge);
            title="Pass";
            pic=R.drawable.pass;
        }
        else {
            messenge="平均: "+String.valueOf(averge);
            title="Fail";
            pic=R.drawable.fail;
        }
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(messenge);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.show();
    }
    public void BackOnclick(View v){
        this.finish();
    }

}
