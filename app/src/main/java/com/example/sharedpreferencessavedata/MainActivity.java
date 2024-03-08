package com.example.sharedpreferencessavedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.SyncFailedException;

public class MainActivity extends AppCompatActivity {

    EditText edname,edphonenumber,edemail,edage,ednidnumber;
    Button btnsave,btnclick;
    TextView tvresult;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    long backpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edname=findViewById(R.id.edname);
        edphonenumber=findViewById(R.id.edphonenumber);
        edemail=findViewById(R.id.edemail);
        edage=findViewById(R.id.edage);
        ednidnumber=findViewById(R.id.ednidnumber);
        btnsave=findViewById(R.id.btnsave);
        btnclick=findViewById(R.id.btnclick);
        tvresult=findViewById(R.id.tvresult);

      btnsave.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String sname=edname.getText().toString();
              String sphonenumber=edphonenumber.getText().toString();
              String semail=edemail.getText().toString();
              String sage=edage.getText().toString();
              String snidnumber=ednidnumber.getText().toString();

              sharedPreferences=getSharedPreferences(""+R.string.app_name,MODE_PRIVATE);
              editor=sharedPreferences.edit();

              editor.putString("name",sname);
              editor.putString("phonenumber",sphonenumber);
              editor.putString("email",semail);
              editor.putString("age",sage);
              editor.putString("nidnumber",snidnumber);
              editor.apply();



          }
      });

      btnclick.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String name=sharedPreferences.getString("name","");
              String phonenumber=sharedPreferences.getString("phonenumber","");
              String email=sharedPreferences.getString("email","");
              String age=sharedPreferences.getString("age","");
              String nidnumber=sharedPreferences.getString("nidnumber","");

              tvresult.append(name+"\n"+phonenumber+"\n"+email+"\n"+age+"\n"+nidnumber);

          }
      });






    }

    @Override
    public void onBackPressed() {

        if (backpress+2000 > System.currentTimeMillis()){

            super.onBackPressed();
            return;

        }else {
            Toast.makeText(this, "press again to exit app", Toast.LENGTH_SHORT).show();
        }

        backpress=System.currentTimeMillis();

    }
}