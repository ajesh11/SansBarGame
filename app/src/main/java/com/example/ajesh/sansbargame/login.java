package com.example.ajesh.sansbargame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText user,pass;
    private ImageButton login,register;
    private TextView t;
    private int count=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText3);
        login=(ImageButton)findViewById(R.id.imageButton);
        register=(ImageButton)findViewById(R.id.imageButton1);
        t=(TextView)findViewById(R.id.textView3);
        t.setText("Number of attemp Remaining : 3");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
                String details = sharedPreferences.getString(username + password + "data", "wrong");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("display", details);
                editor.commit();

                if (details == "wrong") {
                    Toast.makeText(login.this, "UserName and Password is incorrect", Toast.LENGTH_LONG).show();
                    user.setText("");
                    pass.setText("");
                    user.requestFocus();
                    count--;
                    t.setText("Oops! Number of attempt Remaining:"+ String.valueOf(count));


                    if(count==0){
                        login.setEnabled(false);
                        new CountDownTimer(16000,1000){
                            public void onTick(long millisUntilFinished){
                                count++;
                                t.setText("Oops! Suspend For 15 Second Time Running:"+ String.valueOf(count));

                            }

                            public  void onFinish(){
                                count=3;
                                login.setEnabled(true);
                                t.setText("Oops! Number of attempt Remaining:"+ String.valueOf(count));
                            }
                        }.start();

                    }



                }

                     else {
                        Intent intent = new Intent(login.this, MainActivity.class);
                        startActivity(intent);
                    user.setText("");
                    pass.setText("");
                    user.requestFocus();
                    }




            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,register.class);
                startActivity(intent);
            }
        });

    }
}
