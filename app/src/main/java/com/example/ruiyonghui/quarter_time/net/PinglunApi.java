package com.example.ruiyonghui.quarter_time.net;


import com.example.ruiyonghui.quarter_time.bean.PinglunBean;


import io.reactivex.Observable;

/**
 * Created by fxf on 2018.06.05.
 */

public class PinglunApi {
    private static PinglunApi duanziApi;
    private PinglunApiService duanziApiService;

    public PinglunApi(PinglunApiService duanziApiService) {
        this.duanziApiService = duanziApiService;
    }

    public static PinglunApi getDianzan(PinglunApiService duanziApiService) {
        if (duanziApi == null) {
            duanziApi = new PinglunApi(duanziApiService);
        }
        return duanziApi;
    }

    public Observable<PinglunBean> getpinglun(String uid, String jid, String token
    ) {
        return duanziApiService.getpinglun(uid,jid,token);
    }
}