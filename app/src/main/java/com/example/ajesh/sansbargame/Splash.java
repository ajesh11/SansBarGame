package com.example.ajesh.sansbargame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private int time=4;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        pbar=(ProgressBar)findViewById(R.id.pb);
        for(int i=1;i<=4000;i++){

            pbar.setProgress(i);
        }
        getSupportActionBar().hide();
        LogoLuncher logoluncher=new LogoLuncher();
        logoluncher.start();
    }

    private  class LogoLuncher extends Thread{
        public  void run(){
            try {
                sleep(1000 * time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent= new Intent(Splash.this,login.class);
            startActivity(intent);
            Splash.this.finish();

        }

    }
}