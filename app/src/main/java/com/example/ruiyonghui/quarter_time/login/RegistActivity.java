package com.example.ruiyonghui.quarter_time.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.RegisterBean;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.login.contract.RegisterContract;
import com.example.ruiyonghui.quarter_time.login.presenter.RegisterPresenter;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.HomeActivity;
import com.example.ruiyonghui.quarter_time.ui.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.regists)
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
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        mSimpledrawee.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());

        SpannableString spannableString2 = new SpannableString("请输入手机号");
        AbsoluteSizeSpan textSize2 = new AbsoluteSizeSpan(15, true);
        spannableString2.setSpan(textSize2, 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserName.setHint(spannableString2);

        SpannableString spannableString = new SpannableString("请输入大小写和数字,密码不能超过8位");
        AbsoluteSizeSpan textSize = new AbsoluteSizeSpan(15, true);
        spannableString.setSpan(textSize, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mUserPass.setHint(spannableString);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_regist;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void registerSuccess(RegisterBean registerBean) {
        String msg = registerBean.getCode();
        if (msg.equals("0")) {
            Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(RegistActivity.this, registerBean.getMsg(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RegistActivity.this, registerBean.getMsg(), Toast.LENGTH_SHORT).show();
            intent = new Intent(RegistActivity.this, HomeActivity.class);
            startActivity(intent);
        }

    }

    @OnClick({R.id.back, R.id.regists, R.id.user_name, R.id.user_pass, R.id.but_regist, R.id.yk_a})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                intent = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.regists:
                intent = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.simpledrawee:
                break;
            case R.id.user_name:
                break;
            case R.id.user_pass:
                break;
            case R.id.but_regist:
                String mobile = mUserName.getText().toString();
                String password = mUserPass.getText().toString();
                mPresenter.register(mobile, password);
                break;
            case R.id.yk_a:
                intent = new Intent(RegistActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }

}
