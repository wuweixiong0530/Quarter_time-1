package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wwx on 2018/6/6,0006.
 */

public interface GuanZhuService {
//    https://www.zhaoapi.cn/quarter/getFollowUsers?token=36471BDA7A4BD22560CC9A207185CA65&uid=2845&source=android&appVersion=101
    @GET("quarter/getFollowUsers")
    Observable<GuanZhuBean> getGuanZhu(@Query("token") String token,
                                       @Query("uid") String uid);
}
