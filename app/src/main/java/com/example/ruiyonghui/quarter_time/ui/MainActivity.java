package com.example.ruiyonghui.quarter_time.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ruiyonghui.quarter_time.R;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressBar = findViewById( R.id.pro );
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
                            Intent intent=new Intent(MainActivity.this,Home2Activity.class);
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
