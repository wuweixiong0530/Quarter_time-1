package com.example.ruiyonghui.quarter_time.module;

import com.example.ruiyonghui.quarter_time.net.Api;
import com.example.ruiyonghui.quarter_time.net.CollectApi;
import com.example.ruiyonghui.quarter_time.net.CollentApiService;
import com.example.ruiyonghui.quarter_time.net.LoginApi;
import com.example.ruiyonghui.quarter_time.net.LoginApiService;
import com.example.ruiyonghui.quarter_time.net.RegisterApi;
import com.example.ruiyonghui.quarter_time.net.RegisterApiService;
import com.example.ruiyonghui.quarter_time.untils.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
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

    @Provides
    LoginApi provideLoginApi(Retrofit.Builder builder) {
        Retrofit retrofit = builder.build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }
    @Provides
    RegisterApi provideRegisterApi(Retrofit.Builder builder) {
        Retrofit retrofit = builder.build();
        RegisterApiService registerApiService = retrofit.create(RegisterApiService.class);
        return RegisterApi.getRegisterApi(registerApiService);
    }

//    @Provides
//    AdApi provideAdApi(Retrofit.Builder builder) {
////        //builder.addInterceptor(new MyInterceptor());
//        Retrofit retrofit = builder.build();
//        AdApiService adApiService = retrofit.create(AdApiService.class);
//        return AdApi.getAdApi(adApiService);
//    }

    @Provides
    CollectApi provideCollectApi(Retrofit.Builder builder) {
            Retrofit retrofit = builder.build();
        CollentApiService collentApiService = retrofit.create(CollentApiService.class);
        return CollectApi.getCollectApi(collentApiService);
    }

}
