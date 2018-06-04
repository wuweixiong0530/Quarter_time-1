package com.example.ruiyonghui.quarter_time.module;

import com.example.ruiyonghui.quarter_time.net.Api;
import com.example.ruiyonghui.quarter_time.untils.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

//    @Provides
//    AdApi provideAdApi(Retrofit.Builder builder) {
////        //builder.addInterceptor(new MyInterceptor());
//        Retrofit retrofit = builder.build();
//        AdApiService adApiService = retrofit.create(AdApiService.class);
//        return AdApi.getAdApi(adApiService);
//    }
}
