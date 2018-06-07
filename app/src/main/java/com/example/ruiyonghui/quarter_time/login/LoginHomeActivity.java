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
import com.example.ruiyonghui.quarter_time.untils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

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

                break;
            case R.id.login_t:
                intent = new Intent(this,LoginActivity.class);
                startActivity( intent );
                break;
        }
    }

}
