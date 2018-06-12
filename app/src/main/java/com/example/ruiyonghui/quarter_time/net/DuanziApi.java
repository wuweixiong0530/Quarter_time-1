package com.example.ruiyonghui.quarter_time.net;


import com.example.ruiyonghui.quarter_time.bean.DuanziBean;

import io.reactivex.Observable;

/**
 * Created by fxf on 2018.06.05.
 */

public class DuanziApi {
    private static DuanziApi duanziApi;
    private DuanziApiService duanziApiService;

    public DuanziApi(DuanziApiService duanziApiService) {
        this.duanziApiService = duanziApiService;
    }

    public static DuanziApi getDuanziApi(DuanziApiService duanziApiService) {
        if (duanziApi == null) {
            duanziApi = new DuanziApi(duanziApiService);
        }
        return duanziApi;
    }

    public Observable<DuanziBean> getDuanzi(String page) {
        return duanziApiService.getDuanzi(page);
    }
}