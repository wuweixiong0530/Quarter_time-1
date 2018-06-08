package com.example.ruiyonghui.quarter_time.net;

import com.example.ruiyonghui.quarter_time.bean.FollowUsersBean;

import io.reactivex.Observable;

/**
 * Created by wwx on 2018/6/5,0005.
 * 收藏
 */

public class FollowUsersApi {
    public static FollowUsersApi followUsersApi;
    public FollowUsersApiService followUsersApiService;

    private FollowUsersApi(FollowUsersApiService followUsersApiService) {
        this.followUsersApiService = followUsersApiService;
    }

    public static FollowUsersApi getFollowUsersApi(FollowUsersApiService followUsersApiService) {
        if (followUsersApi == null) {
            followUsersApi = new FollowUsersApi(followUsersApiService);
        }
        return followUsersApi;
    }

    public Observable<FollowUsersBean> getFollowUsers(String uid, String token) {
        return followUsersApiService.getFollowUsers( uid, token );
    }
}
