package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.AdvertiseBean;
import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;

import io.reactivex.Observable;

/**
 * Created by wwx on 2018/6/5,0005.
 */

public class ReMenApi {
    private static ReMenApi reMenApi;
    public ReMenService reMenService;

    public ReMenApi(ReMenService reMenService){
        this.reMenService = reMenService;
    }

    public static ReMenApi getReMenApi(ReMenService reMenService){
        if (reMenApi == null){
            reMenApi = new ReMenApi(reMenService);
        }
        return reMenApi;
    }

    //轮播
    public Observable<AdvertiseBean> getReMen(){
        return reMenService.getLuunBo();
    }


}
