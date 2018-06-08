package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.HotVideoBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/6/8,0008.
 */

public class VideoOneApi {
    private static VideoOneApi videoOneApi;
    public VideoOneService videoOneService;

    public VideoOneApi(VideoOneService videoOneService) {
        this.videoOneService = videoOneService;
    }

   public static VideoOneApi getVideoOne(VideoOneService videoOneService){
        if (videoOneApi == null){
            videoOneApi = new VideoOneApi(videoOneService);
        }
        return videoOneApi;
   }

   public Observable<HotVideoBean> getVideoOne(String token,String page){
       return videoOneService.getVideoOne(token,page);
   };
}
