package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/6/6,0006.
 */

public class HtoVideoApi {

    private static HtoVideoApi api;
    public HotVideoService hotVideoService;

    public HtoVideoApi(HotVideoService hotVideoService){
        this.hotVideoService = hotVideoService;
    }

    public static HtoVideoApi getHotVideo(HotVideoService hotVideoService){
        if (api == null){
            api = new HtoVideoApi(hotVideoService);
        }
        return api;
    }

    //热门视频列表
    public Observable<HotVideoBean> getHotVideo(String token,String page){
        return hotVideoService.getHotVideo(token,page);
    }
}
