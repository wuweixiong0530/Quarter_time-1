package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApiService {
    @FormUrlEncoded
    @POST("quarter/register")
    Observable<RegisterBean> register(@Field("mobile") String mobile, @Field("password") String password);
}
