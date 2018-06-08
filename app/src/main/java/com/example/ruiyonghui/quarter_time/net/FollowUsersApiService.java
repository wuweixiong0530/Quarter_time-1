package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.FollowUsersBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wwx on 2018/6/5,0005.
 * 收藏
 */

public interface FollowUsersApiService {

    //https://www.zhaoapi.cn/quarter/getFavorites?uid=2845&token=36471BDA7A4BD22560CC9A207185CA65&source=android&appVersion=101

    @GET("quarter/getFollowUsers")
    Observable<FollowUsersBean> getFollowUsers(@Query("uid") String uid,
                                           @Query("token") String token);
}

