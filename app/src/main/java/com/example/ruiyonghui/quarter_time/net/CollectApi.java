package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.FavoritesBean;

import io.reactivex.Observable;

/**
 * Created by wwx on 2018/6/5,0005.
 * 收藏
 */

public class CollectApi {
    public static CollectApi collectApi;
    public CollentApiService collentApiService;

    private CollectApi(CollentApiService collentApiService) {
        this.collentApiService = collentApiService;
    }

    public static CollectApi getCollectApi(CollentApiService collentApiService) {
        if (collectApi == null) {
            collectApi = new CollectApi(collentApiService);
        }
        return collectApi;
    }

    public Observable<FavoritesBean> getFavorites(String uid,String token) {
        return collentApiService.getFavorites(uid,token);
    }
}
