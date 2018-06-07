package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.GuanZhuBean;

import io.reactivex.Observable;

/**
 * Created by wwx on 2018/6/6,0006.
 */

public class GuanZhuApi {
    private static GuanZhuApi guanZhuApi;
    public GuanZhuService guanZhuService;

    public GuanZhuApi(GuanZhuService guanZhuService) {
        this.guanZhuService = guanZhuService;
    }

    public static GuanZhuApi getGuanZhu(GuanZhuService guanZhuService) {
        if (guanZhuApi == null) {
            guanZhuApi = new GuanZhuApi(guanZhuService);
        }
        return guanZhuApi;
    }

    //关注的视频列表
    public Observable<GuanZhuBean> getGuanZhu(String token, String uid) {
        return guanZhuService.getGuanZhu(token, uid);
    }
}
