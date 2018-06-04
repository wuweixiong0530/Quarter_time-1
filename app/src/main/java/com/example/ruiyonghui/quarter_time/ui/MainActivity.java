package com.example.ruiyonghui.quarter_time.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruiyonghui.quarter_time.R;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    sleep(2000);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
