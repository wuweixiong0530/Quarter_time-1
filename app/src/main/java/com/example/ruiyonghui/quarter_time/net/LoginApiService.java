package com.example.ruiyonghui.quarter_time.net;


import com.example.ruiyonghui.quarter_time.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApiService {

    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> login(@Field("mobile") String mobile,
                                @Field("password") String password);
}
