package com.example.ajesh.sansbargame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

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
                SharedPreferences sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
                String us=un.getText().toString();
                String ps=pw.getText().toString();
                String e=ea.getText().toString();
                SharedPreferences.Editor edit=sharedPreferences.edit();
                edit.putString(us + ps+"data","ajesh");
                edit.commit();
                Intent intents = new Intent(register.this,MainActivity.class);
                startActivity(intents);
                register.this.finish();
            }
        });





    }
}
