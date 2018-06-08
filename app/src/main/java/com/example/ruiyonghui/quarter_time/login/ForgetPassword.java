package com.example.ruiyonghui.quarter_time.login;

import android.content.Context;
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
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class ForgetPassword extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.regist)
    TextView mRegist;
    @BindView(R.id.simpledrawee)
    SimpleDraweeView mSimpledrawee;
    @BindView(R.id.user_name)
    EditText mUserName;
    @BindView(R.id.user_phone)
    TextView mUserPhone;
    @BindView(R.id.user_pass)
    EditText mUserPass;
    @BindView(R.id.but_login)
    Button mButLogin;
    @BindView(R.id.yk_a)
    TextView mYkA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_forget_password );
        ButterKnife.bind( this );
        mSimpledrawee.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());
    }

    @OnClick({R.id.back, R.id.regist, R.id.simpledrawee, R.id.user_name, R.id.user_phone, R.id.user_pass, R.id.but_login, R.id.yk_a})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.regist:
                startActivity( new Intent( this,LoginActivity.class ) );
                break;
            case R.id.simpledrawee:
                break;
            case R.id.user_name:
                break;
            case R.id.user_phone:
                sendCode("86",mUserName.getText().toString());
                break;
            case R.id.user_pass:
                break;
            case R.id.but_login:
                submitCode("86",mUserName.getText().toString(),mUserPass.getText().toString());
                break;
            case R.id.yk_a:
                break;
        }
    }
    public void sendCode(Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country"); // 国家代码，如“86”
                    String phone = (String) phoneMap.get("phone"); // 手机号码，如“13800138000”
                    // TODO 利用国家代码和手机号码进行后续的操作
                } else{
                    // TODO 处理错误的结果
                }
            }
        });
        page.show(context);
    }
    // 请求验证码，其中country表示国家代码，如“86”；phone表示手机号码，如“13800138000”
    public void sendCode(String country, String phone) {
        // 注册一个事件回调，用于处理发送验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理成功得到验证码的结果
                    // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                } else{
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.getVerificationCode(country, phone);
    }

    // 提交验证码，其中的code表示验证码，如“1357”
    public void submitCode(String country, String phone, String code) {
        // 注册一个事件回调，用于处理提交验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理验证成功的结果
                    startActivity( new Intent( ForgetPassword.this,SuccessActivity.class ) );
                } else{
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.submitVerificationCode(country, phone, code);
    }

    protected void onDestroy() {
        super.onDestroy();
        //用完回调要注销掉，否则可能会出现内存泄露
        SMSSDK.unregisterAllEventHandler();
    };
}
