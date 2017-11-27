package com.example.ajesh.sansbargame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register extends AppCompatActivity {
private EditText un,pw,ea;
private ImageButton ib;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        un=(EditText)findViewById(R.id.editText10);
        pw=(EditText)findViewById(R.id.editText11);
        ea=(EditText)findViewById(R.id.editText12);
        ib=(ImageButton)findViewById(R.id.imageButton10);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";


                String email = ea.getText().toString();

                Matcher matcher= Pattern.compile(validemail).matcher(email);


                if (matcher.matches()){
                    String us=un.getText().toString();
                    String ps=pw.getText().toString();
                    String e=ea.getText().toString();
                    if((us.isEmpty()||(ps.isEmpty()))){
                        Toast.makeText(getApplicationContext(),"Enter UserName and Password",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_LONG).show();
                        ib.setEnabled(true);

                        SharedPreferences sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);

                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString( us + ps + "data", "ajesh");
                        edit.putString(e+ps+"email","hellow");
                        edit.commit();
                        Intent intents = new Intent(register.this, MainActivity.class);
                        startActivity(intents);
                        register.this.finish();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
                }










            }
        });





    }
}
