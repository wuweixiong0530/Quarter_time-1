package com.example.ruiyonghui.quarter_time.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruiyonghui.quarter_time.R;
import com.example.ruiyonghui.quarter_time.ui.HomeActivity;
import com.example.ruiyonghui.quarter_time.ui.MainActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.json.JSONException;
import org.json.JSONObject;

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
    private static final String TAG = "LoginHomeActivity";

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

                break;
            case R.id.qq:
                //之所以要删除授权，是因为每次都拉取对应授权页
                //否则是直接授权并不能切换其他账号登入
                umengDeleteOauth( SHARE_MEDIA.QQ);
                //开始授权
                shareLoginUmeng(this, SHARE_MEDIA.QQ);
                //shareLoginUmeng(this, SHARE_MEDIA.WEIXIN);
                //shareLoginUmeng(this, SHARE_MEDIA.SINA);

                break;
            case R.id.login_t:
                intent = new Intent(this,LoginActivity.class);
                startActivity( intent );
                break;
        }
    }
    /**
     * 友盟开始授权(登入)
     */
    public static void shareLoginUmeng(final Activity activity, SHARE_MEDIA share_media_type) {

        UMShareAPI.get(activity).getPlatformInfo(activity, share_media_type, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Log.e(TAG, "onStart授权开始: ");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                //sdk是6.4.5的,但是获取值的时候用的是6.2以前的(access_token)才能获取到值,未知原因
                String uid = map.get("uid");
                String openid = map.get("openid");//微博没有
                String unionid = map.get("unionid");//微博没有
                String access_token = map.get("access_token");
                String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
                String expires_in = map.get("expires_in");
                String name = map.get("name");//名称
                String gender = map.get("gender");//性别
                String iconurl = map.get("iconurl");//头像地址

                Log.e(TAG, "onStart授权完成: " + openid);
                Log.e(TAG, "onStart授权完成: " + unionid);
                Log.e(TAG, "onStart授权完成: " + access_token);
                Log.e(TAG, "onStart授权完成: " + refresh_token);
                Log.e(TAG, "onStart授权完成: " + expires_in);
                Log.e(TAG, "onStart授权完成: " + uid);
                Log.e(TAG, "onStart授权完成: " + name);
                Log.e(TAG, "onStart授权完成: " + gender);
                Log.e(TAG, "onStart授权完成: " + iconurl);
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Toast.makeText(activity, "授权失败", Toast.LENGTH_LONG).show();
                Log.e(TAG, "onError: " + "授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Toast.makeText(activity, "授权取消", Toast.LENGTH_LONG).show();
                Log.e(TAG, "onError: " + "授权取消");
            }
        });
    }

    /**
     * 友盟取消授权（登入）
     */
    private void umengDeleteOauth(SHARE_MEDIA share_media_type) {

        UMShareAPI.get(this).deleteOauth(this, share_media_type, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                //开始授权
                Log.e(TAG, "onStart: ");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                //取消授权成功 i=1
                Log.e(TAG, "onComplete: ");
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                //授权出错
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                //取消授权
                Log.e(TAG, "onCancel: ");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: " + requestCode + "\n" + resultCode + "\n" + data);
    }
}
