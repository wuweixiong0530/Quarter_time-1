package com.example.ruiyonghui.quarter_time.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
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

                SharedPreferencesUtils.setParam(this, "uid", "");
                SharedPreferencesUtils.setParam(this, "password", "");

                Object uid = SharedPreferencesUtils.getParam(this, "uid", "");
                Object password = SharedPreferencesUtils.getParam(this, "password", "");

                if (TextUtils.isEmpty((CharSequence) uid) && TextUtils.isEmpty((CharSequence) password)) {
                    Toast.makeText(this, "退出成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "退出失败", Toast.LENGTH_SHORT).show();

                }

                break;
            default:
                break;
        }

    }
}