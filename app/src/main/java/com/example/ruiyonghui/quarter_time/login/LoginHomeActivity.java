package com.example.ruiyonghui.quarter_time.login;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.ui.HomeActivity;
import com.example.ruiyonghui.quarter_time.ui.MainActivity;
import com.example.ruiyonghui.quarter_time.untils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginHomeActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.weixin)
    ImageView mWeixin;
    @BindView(R.id.qq)
    ImageView mQq;
    @BindView(R.id.login_t)
    TextView mLoginT;
    @BindView(R.id.simple)
    SimpleDraweeView simpleDraweeView;
    private Intent intent;
    //5b17e7d3a40fa368580000ec

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_loginhome );
        ButterKnife.bind( this );
        simpleDraweeView.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());
    }

    @OnClick({R.id.back, R.id.weixin, R.id.qq, R.id.login_t})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                intent = new Intent(LoginHomeActivity.this,HomeActivity.class);
                startActivity( intent );
                break;
            case R.id.weixin:
                //shareLoginUmeng(this, SHARE_MEDIA.WEIXIN);
                //shareLoginUmeng(this, SHARE_MEDIA.SINA);

                break;
            case R.id.qq:

                UMShareAPI mShareAPI = UMShareAPI.get(LoginHomeActivity.this);
                mShareAPI.getPlatformInfo(LoginHomeActivity.this, SHARE_MEDIA.QQ, umAuthListener);

                break;
            case R.id.login_t:
                intent = new Intent(this,LoginActivity.class);
                startActivity( intent );
                break;
        }
    }
    //授权的事件
    UMAuthListener umAuthListener = new UMAuthListener() {

        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.e("onStart", "onStart"); }
        //授权成功了。map里面就封装了一些qq信息
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

            Log.e( "zzzz",map.toString() );
            String uid = map.get("uid");
            String openid = map.get("openid");//微博没有
            String unionid = map.get("unionid");//微博没有
            String access_token = map.get("access_token");
            String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
            String expires_in = map.get("expires_in");
            String name = map.get("name");//名称
            String gender = map.get("gender");//性别
            String iconurl = map.get("iconurl");//头像地址
            SharedPreferencesUtils.setParam(LoginHomeActivity.this,"name",name);
            SharedPreferencesUtils.setParam(LoginHomeActivity.this,"iconurl",iconurl);
            SharedPreferencesUtils.setParam(LoginHomeActivity.this,"uid",uid);
            Intent intent = new Intent(LoginHomeActivity.this,HomeActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "name=" + name + ",gender=" + gender+"iconurl"+iconurl, Toast.LENGTH_SHORT).show();
        }
        //授权失败
        @Override public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Log.e("onError", "onError");
        }

        @Override public void onCancel(SHARE_MEDIA share_media, int i) {
            Log.e("onCancel", "onCancel");
        }
    };
    //授权回调
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}






