package com.example.ruiyonghui.quarter_time.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.login.LoginHomeActivity;
import com.example.ruiyonghui.quarter_time.untils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.banben_tv)
    TextView banbenTv;
    @BindView(R.id.huancun_tv)
    TextView huancunTv;
    @BindView(R.id.btn_tui)
    Button btnTui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        tvBack.setOnClickListener(this);
        btnTui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.btn_tui:
                //清空SharedPreferences
                SharedPreferencesUtils.clear(SettingActivity.this);
                //回到登录页面
                Intent intent = new Intent(SettingActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                SettingActivity.this.finish();
                break;
            default:


                break;
        }

    }
}