package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wwx on 2018/6/5,0005.
 * 收藏
 */

public interface CollentApiService {

    //https://www.zhaoapi.cn/quarter/getFavorites?uid=2845&token=36471BDA7A4BD22560CC9A207185CA65&source=android&appVersion=101

    @GET("quarter/getFavorites")
    Observable<FavoritesBean> getFavorites(@Query("uid") String uid,
                                      @Query("token") String token,
                                      @Query("source") String source,
                                      @Query("appVersion") String appVersion);
}

