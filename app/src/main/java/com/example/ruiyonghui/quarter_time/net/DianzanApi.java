package com.example.ruiyonghui.quarter_time.net;


import com.example.ruiyonghui.quarter_time.bean.DianzanBean;

import io.reactivex.Observable;

/**
 * Created by fxf on 2018.06.05.
 */

public class DianzanApi {
    private static DianzanApi duanziApi;
    private DianzanApiService duanziApiService;

    public DianzanApi(DianzanApiService duanziApiService) {
        this.duanziApiService = duanziApiService;
    }

    public static DianzanApi getDianzan(DianzanApiService duanziApiService) {
        if (duanziApi == null) {
            duanziApi = new DianzanApi(duanziApiService);
        }
        return duanziApi;
    }

    public Observable<DianzanBean> getDianzan(String uid, String jid, String token) {
        return duanziApiService.getdianzan(uid,jid,token);
    }
}