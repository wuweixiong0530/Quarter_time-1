package com.example.ruiyonghui.quarter_time.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco
        Fresco.initialize(this);
        //初始化友盟SDK
        UMShareAPI.get(this);//初始化sd
        //开启debug模式，方便定位错误，具体错误检查方式可以查看
        //http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
        Config.DEBUG = true;
        //应用宝开放平台  APP ID  APP KEY
        PlatformConfig.setQQZone("1111114798", "aEIMjd6vWSADA5ol");
    }
}
