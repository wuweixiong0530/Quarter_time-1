package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.DianzanBean;
import com.example.ruiyonghui.quarter_time.bean.DuanziBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fxf on 2018.06.05.
 */

public interface DuanziApiService {

    @FormUrlEncoded
    @POST("quarter/getJokes")
    Observable<DuanziBean> getDuanzi(@Field("page") String page);

    @FormUrlEncoded
    @POST("quarter/jokePraise")
    Observable<DianzanBean> getdianzan(@Field("uid") String uid, @Field("jid") String jid);
}
