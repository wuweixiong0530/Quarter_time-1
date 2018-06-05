package com.example.ruiyonghui.quarter_time.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.bean.LoginBean;
import com.example.ruiyonghui.quarter_time.component.DaggerHttpComponent;
import com.example.ruiyonghui.quarter_time.login.contract.LoginContract;
import com.example.ruiyonghui.quarter_time.login.presenter.LoginPresenter;
import com.example.ruiyonghui.quarter_time.module.HttpModule;
import com.example.ruiyonghui.quarter_time.ui.HomeActivity;
import com.example.ruiyonghui.quarter_time.ui.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener, LoginContract.View {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.regist)
    TextView mRegist;
    @BindView(R.id.simpledrawee)
    SimpleDraweeView mSimpledrawee;
    @BindView(R.id.user_name)
    EditText mUserName;
    @BindView(R.id.user_pass)
    EditText mUserPass;
    @BindView(R.id.but_login)
    Button mButLogin;
    @BindView(R.id.xgmima)
    TextView mXgmima;
    @BindView(R.id.yk_a)
    TextView mYkA;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( getContentLayout() );
        ButterKnife.bind( this );
        mSimpledrawee.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());
    }



    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        Toast.makeText(LoginActivity.this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.back, R.id.regist, R.id.user_name, R.id.user_pass, R.id.but_login, R.id.xgmima, R.id.yk_a})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                intent = new Intent(LoginActivity.this,LoginHomeActivity.class);
                startActivity( intent );
                break;
            case R.id.regist:
                Intent intent = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity( intent );
                break;
            case R.id.user_name:
                break;
            case R.id.user_pass:
                break;
            case R.id.but_login:
                //需要调用P层，去完成接口调用
                String mobile = mUserName.getText().toString();
                String password = mUserPass.getText().toString();
                mPresenter.login(mobile, password);
                break;
            case R.id.xgmima:
                break;
            case R.id.yk_a:
                intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity( intent );
                break;
        }
    }
}
