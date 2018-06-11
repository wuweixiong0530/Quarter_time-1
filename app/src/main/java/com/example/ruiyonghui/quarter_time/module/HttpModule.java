package com.example.ruiyonghui.quarter_time.module;

import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;
import com.example.ruiyonghui.quarter_time.net.Api;
import com.example.ruiyonghui.quarter_time.net.CollectApi;
import com.example.ruiyonghui.quarter_time.net.CollentApiService;
import com.example.ruiyonghui.quarter_time.net.FollowUsersApi;
import com.example.ruiyonghui.quarter_time.net.FollowUsersApiService;
import com.example.ruiyonghui.quarter_time.net.GuanZhuApi;
import com.example.ruiyonghui.quarter_time.net.GuanZhuService;
import com.example.ruiyonghui.quarter_time.net.HotVideoService;
import com.example.ruiyonghui.quarter_time.net.HtoVideoApi;
import com.example.ruiyonghui.quarter_time.net.LoginApi;
import com.example.ruiyonghui.quarter_time.net.LoginApiService;
import com.example.ruiyonghui.quarter_time.net.ReMenApi;
import com.example.ruiyonghui.quarter_time.net.ReMenService;
import com.example.ruiyonghui.quarter_time.net.RegisterApi;
import com.example.ruiyonghui.quarter_time.net.RegisterApiService;
import com.example.ruiyonghui.quarter_time.net.VideoOneApi;
import com.example.ruiyonghui.quarter_time.net.VideoOneService;

import com.example.ruiyonghui.quarter_time.untils.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {

        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }
    @Provides
    Retrofit.Builder provideRetrofit(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        return new Retrofit.Builder()
                .baseUrl( Api.BASEURL)
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
                .addConverterFactory( GsonConverterFactory.create())
                .client(builder.build());
    }

    //登录
    @Provides
    LoginApi provideLoginApi(Retrofit.Builder builder) {
        Retrofit retrofit = builder.build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }
    //注册
    @Provides
    RegisterApi provideRegisterApi(Retrofit.Builder builder) {
        Retrofit retrofit = builder.build();
        RegisterApiService registerApiService = retrofit.create(RegisterApiService.class);
        return RegisterApi.getRegisterApi(registerApiService);
    }


    //收藏
    @Provides
    CollectApi provideCollectApi(Retrofit.Builder builder) {
        Retrofit retrofit = builder.build();
        CollentApiService collentApiService = retrofit.create(CollentApiService.class);
        return CollectApi.getCollectApi(collentApiService);
    }

    //轮播
    @Provides
    ReMenApi provideReMenApi(Retrofit.Builder builder){
        Retrofit retrofit = builder.build();

        ReMenService reMenService = retrofit.create(ReMenService.class);
        return ReMenApi.getReMenApi(reMenService);
    }

    //热门视频
    @Provides
    HtoVideoApi provideHotVideoApi(Retrofit.Builder builder){
        Retrofit retrofit = builder.build();
        HotVideoService hotVideoService = retrofit.create(HotVideoService.class);
        return HtoVideoApi.getHotVideo(hotVideoService);
    }

    //侧拉我的关注
    @Provides
    FollowUsersApi provideFollowUsersApi(Retrofit.Builder builder){
        Retrofit retrofit = builder.build();
        FollowUsersApiService followUsersApiService = retrofit.create( FollowUsersApiService.class );
        return FollowUsersApi.getFollowUsersApi( followUsersApiService );
    }
    //关注
    @Provides
    GuanZhuApi provideGuanZhuApi(Retrofit.Builder builder){
        Retrofit retrofit = builder.build();
        GuanZhuService guanZhuService = retrofit.create(GuanZhuService.class);
        return GuanZhuApi.getGuanZhu(guanZhuService);
    }

    @Provides
    VideoOneApi provideVideoOneApi(Retrofit.Builder builder){
        Retrofit retrofit = builder.build();
        VideoOneService videoOneService = retrofit.create(VideoOneService.class);
        return VideoOneApi.getVideoOne(videoOneService);
    }

}
