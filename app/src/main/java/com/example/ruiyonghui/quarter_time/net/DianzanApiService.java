package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.DianzanBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fxf on 2018.06.05.
 */

public interface DianzanApiService {
    //点赞
////https://www.zhaoapi.cn/quarter/jokePraise?uid=13159&jid=12882&token=EAF325D28B78B3F831F29CA2A46B63F3&source=android&appVersion=101
        //评论
    //https://www.zhaoapi.cn/quarter/commentJoke?uid=13159&jid=12882&token=EAF325D28B78B3F831F29CA2A46B63F3&source=android&appVersion=101
    @FormUrlEncoded
    @POST("quarter/jokePraise")
    Observable<DianzanBean> getdianzan(@Field("uid") String uid, @Field("jid") String jid, @Field("token") String token);
}
