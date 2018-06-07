package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/6/6,0006.
 */

public interface HotVideoService {
    //https://www.zhaoapi.cn/quarter/getHotVideos?token=36471BDA7A4BD22560CC9A207185CA65&source=android&page=1
    //热门视频列表
    @GET("quarter/getHotVideos")
    Observable<HotVideoBean> getHotVideo(@Query("token") String token,
                                         @Query("page") String page);
}
