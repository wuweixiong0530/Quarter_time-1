package com.example.ruiyonghui.quarter_time.net;


import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wwx on 2018/6/8,0008.
 */

public interface VideoOneService {
    @GET("quarter/getHotVideos")
    Observable<HotVideoBean> getVideoOne(@Query("token") String token,
                                         @Query("page") String page);
}
