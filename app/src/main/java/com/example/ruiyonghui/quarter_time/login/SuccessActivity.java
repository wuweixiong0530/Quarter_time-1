package com.example.ruiyonghui.quarter_time.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.ui.HomeActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuccessActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.but_ok)
    TextView mRegists;
    @BindView(R.id.simpledrawee)
    SimpleDraweeView mSimpledrawee;
    @BindView(R.id.user_name)
    EditText mUserName;
    @BindView(R.id.user_pass)
    EditText mUserPass;
    @BindView(R.id.but_regist)
    Button mButRegist;
    @BindView(R.id.yk_a)
    TextView mYkA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_success );
        ButterKnife.bind( this );
        mSimpledrawee.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());
    }

    @OnClick({R.id.back, R.id.regists, R.id.simpledrawee, R.id.user_name, R.id.user_pass, R.id.but_ok, R.id.yk_a})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.regists:
                break;
            case R.id.simpledrawee:
                break;
            case R.id.user_name:
                break;
            case R.id.user_pass:
                break;
            case R.id.but_ok:
                startActivity( new Intent( SuccessActivity.this,LoginActivity.class ) );
                break;
            case R.id.yk_a:
                startActivity( new Intent( SuccessActivity.this,HomeActivity.class ) );
                break;
        }
    }
}
